import 'package:tugas_api/app/models/user.dart';
import 'package:vania/vania.dart';

class AuthController extends Controller {
  Future<Response> register(Request request) async {
    request.validate({
      'user_name': 'required',
      'user_email': 'required|email',
      'user_password': 'required|min_length:6',
    }, {
      'user_name.required': 'nama tidak boleh kosong',
      'user_email.required': 'email tidak boleh kosong',
      'user_email.email': 'email tidak valid',
      'password.required': 'password tidak boleh kosong',
      'password.min_length': 'password harus terdiri dari minimal 6 karakter',
    });

    final user_name = request.input('user_name');
    final user_email = request.input('user_email');
    var user_password = request.input('user_password').toString();

    var user =
        await User().query().where('user_email', '=', user_email).first();
    if (user != null) {
      return Response.json({
        "message": "user sudah ada",
      }, 409);
    }

    user_password = Hash().make(user_password);
    await User().query().insert({
      "user_name": user_name,
      "user_email": user_email,
      "user_password": user_password,
      "created_at": DateTime.now().toIso8601String(),
    });

    return Response.json({"message": "berhasil mendaftarkan user"}, 201);
  }

  Future<Response> login(Request request) async {
    request.validate({
      'user_email': 'required|email',
      'user_password': 'required',
    }, {
      'user_email.required': 'email tidak boleh kosong',
      'user_email.email': 'email tidak valid',
      'password.required': 'password tidak boleh kosong',
    });

    final user_email = request.input('user_email');
    var user_password = request.input('user_password').toString();

    var user =
        await User().query().where('user_email', '=', user_email).first();
    if (user == null) {
      return Response.json({
        "message": "user belum terdaftar",
      }, 409);
    }

    if (!Hash().verify(user_password, user['user_password'])) {
      return Response.json({
        "message": "kata sandi yang anda masukan salah",
      }, 401);
    }

    final token = await Auth()
        .login(user)
        .createToken(expiresIn: Duration(days: 30), withRefreshToken: true);

    return Response.json({
      "message": "berhasil login",
      "token": token,
    });
  }
}

final AuthController authController = AuthController();
