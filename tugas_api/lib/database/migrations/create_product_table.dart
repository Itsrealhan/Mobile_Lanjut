import 'package:vania/vania.dart';

class CreateProductTable extends Migration {
  @override
  Future<void> up() async {
    super.up();
    await createTableNotExists('product', () {
      id();
      bigInt('vend_id', unsigned: true);
      foreign('vend_id', 'vendor', 'id',
          constrained: true, onDelete: 'CASCADE');
      string('prod_name');
      integer('prod_price');
      text('prod_desc');
      timeStamps();
    });
  }

  @override
  Future<void> down() async {
    super.down();
    await dropIfExists('product');
  }
}
