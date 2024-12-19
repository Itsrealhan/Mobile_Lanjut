import 'package:tugas_api/app/models/order.dart';
import 'package:vania/vania.dart';

class OrderController extends Controller {
  Future<Response> index() async {
    final order = await Order().query().select(['cust_id', 'order_date']).get();
    return Response.json(
        {'data': order, 'message': 'order berhasil diambil'}, 200);
  }

  Future<Response> create(Request request) async {
    request.validate({
      'cust_id': 'required',
      'order_date': 'required',
    });

    // Insert ke tabel orders
    final order = await Order().query().insert({
      'cust_id': request.input('cust_id'),
      'order_date': request.input('order_date'),
    });

    // Response sukses
    return Response.json(
        {'message': 'Order berhasil ditambahkan', 'data': order}, 201);
  }

  Future<Response> store(Request request) async {
    return Response.json({});
  }

  Future<Response> show(int id) async {
    return Response.json({});
  }

  Future<Response> edit(int id) async {
    return Response.json({});
  }

  Future<Response> update(Request request, int id) async {
    return Response.json({});
  }

  Future<Response> destroy(int id) async {
    final order = await Order().query().where('id', '=', id).delete();
    return Response.json(
        {'data': order, 'message': 'order berhasil dihapus'}, 200);
  }
}

final OrderController orderController = OrderController();
