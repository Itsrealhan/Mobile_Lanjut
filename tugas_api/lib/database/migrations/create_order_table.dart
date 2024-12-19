import 'package:vania/vania.dart';

class CreateOrderTable extends Migration {
  @override
  Future<void> up() async {
    super.up();
    await createTableNotExists('order', () {
      id();
      bigInt('cust_id', unsigned: true);
      foreign('cust_id', 'customer', 'id', constrained: true);
      date('order_date');
      timeStamps();
    });
  }

  @override
  Future<void> down() async {
    super.down();
    await dropIfExists('order');
  }
}
