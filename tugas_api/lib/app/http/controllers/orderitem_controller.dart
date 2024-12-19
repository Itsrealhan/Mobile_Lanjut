import 'package:tugas_api/app/models/order.dart';
import 'package:vania/vania.dart';

class OrderitemController extends Controller {
  Future<Response> index() async {
    final order =
        await Order().query().select(['order_id', 'prod_id', 'quantity']).get();
    return Response.json(
        {'data': order, 'message': 'order berhasil diambil'}, 200);
  }

  Future<Response> create(Request request) async {
    request.validate({
      'order_id': 'required',
      'prod_id': 'required',
      'quantity': 'required',
    });

    final order = await Order().query().insert({
      'order_id': request.input('order_id'),
      'prod_id': request.input('prod_id'),
      'quantity': request.input('quantity'),
    });

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

final OrderitemController orderitemController = OrderitemController();
