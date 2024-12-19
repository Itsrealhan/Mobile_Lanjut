import 'package:vania/vania.dart';

class CreateOrderitemTable extends Migration {
  @override
  Future<void> up() async {
    super.up();
    await createTableNotExists('orderitem', () {
      id();
      bigInt('order_id', unsigned: true);
      foreign('order_id', 'order', 'id',
          constrained: true, onDelete: 'CASCADE');
      bigInt('prod_id', unsigned: true);
      foreign('prod_id', 'product', 'id',
          constrained: true, onDelete: 'CASCADE');
      integer('quantity');
      timeStamps();
    });
  }

  @override
  Future<void> down() async {
    super.down();
    await dropIfExists('orderitem');
  }
}
