import 'package:tugas_api/app/models/product.dart';
import 'package:vania/vania.dart';

class ProductController extends Controller {
  Future<Response> index() async {
    List<Map<String, dynamic>> product = await Product()
        .query()
        .select(['vend_id', 'prod_name', 'prod_price', 'prod_desc']).get();
    return Response.json(
        {'data': product, 'message': 'produk berhasil diambil'}, 200);
  }

  Future<Response> create(Request request) async {
    request.validate({
      'vend_id': 'required',
      'prod_name': 'required',
      'prod_price': 'required',
      'prod_desc': 'required'
    });

    final product = await Product().query().insert({
      'vend_id': request.input('vend_id'),
      'prod_name': request.input('prod_name'),
      'prod_price': request.input('prod_price'),
      'prod_desc': request.input('prod_desc')
    });
    return Response.json(
        {'data': product, 'message': 'produk berhasil ditambahkan'}, 201);
  }

  Future<Response> update(Request request, int id) async {
    request.validate({
      'vend_id': 'required',
      'prod_name': 'required',
      'prod_price': 'required',
      'prod_desc': 'required'
    });

    final product = await Product().query().where('id', '=', id).update({
      'vend_id': request.input('vend_id'),
      'prod_name': request.input('prod_name'),
      'prod_price': request.input('prod_price'),
      'prod_desc': request.input('prod_desc')
    });
    return Response.json(
        {'data': product, 'message': 'produk berhasil diubah'}, 200);
  }

  Future<Response> destroy(int id) async {
    final product = await Product().query().where('id', '=', id).delete();
    return Response.json(
        {'data': product, 'message': 'produk berhasil dihapus'}, 200);
  }
}

final ProductController productController = ProductController();
