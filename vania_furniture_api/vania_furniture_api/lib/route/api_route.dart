import 'package:vania/vania.dart';
import 'package:vania_furniture_api/app/http/controllers/auth_controller.dart';
import 'package:vania_furniture_api/app/http/controllers/todo_controller.dart';
import 'package:vania_furniture_api/app/http/controllers/user_controller.dart';
import 'package:vania_furniture_api/app/http/middleware/authenticate.dart';

class ApiRoute implements Route {
  @override
  void register() {
    /// Base RoutePrefix
    Router.basePrefix('api');
    Router.group(() {
      Router.post('register', authController.register);
      Router.post('login', authController.login);
    }, prefix: 'auth');

    Router.group(() {
      Router.patch('update-password', userController.updatePassword);
      Router.get('', userController.index);
    }, prefix: 'user', middleware: [AuthenticateMiddleware()]);

    Router.group(() {
      Router.post('todo', todoController.store);
    }, prefix: 'todo', middleware: [AuthenticateMiddleware()]);
  }
}
