import 'package:vania/vania.dart';

class CreateProductnoteTable extends Migration {
  @override
  Future<void> up() async {
    super.up();
    await createTableNotExists('productnote', () {
      id();
      bigInt('prod_id', unsigned: true);
      foreign('prod_id', 'product', 'id',
          constrained: true, onDelete: 'CASCADE');
      date('note_date');
      longText('note_text');
      timeStamps();
    });
  }

  @override
  Future<void> down() async {
    super.down();
    await dropIfExists('productnote');
  }
}
