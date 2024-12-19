import 'package:tugas_api/app/http/controllers/auth_controller.dart';
import 'package:tugas_api/app/http/controllers/customer_controller.dart';
import 'package:tugas_api/app/http/controllers/order_controller.dart';
import 'package:tugas_api/app/http/controllers/product_controller.dart';
import 'package:tugas_api/app/http/controllers/productnote_controller.dart';
import 'package:tugas_api/app/http/controllers/vendor_controller.dart';
import 'package:vania/vania.dart';
// import 'package:tugas_api/app/http/controllers/home_controller.dart';
import 'package:tugas_api/app/http/middleware/authenticate.dart';
import 'package:tugas_api/app/http/middleware/home_middleware.dart';
import 'package:tugas_api/app/http/middleware/error_response_middleware.dart';

class ApiRoute implements Route {
  @override
  void register() {
    /// Base RoutePrefix
    Router.basePrefix('api');

    // Router.get("/home", homeController.index);

    Router.post("/login", authController.login);
    Router.post("/register", authController.register);

    Router.group(() {
      Router.post("/product/create", productController.create);
      Router.get("/product/get", productController.index);
      Router.patch("/product/update/{id}", productController.update);
      Router.delete("/product/delete/{id}", productController.destroy);

      Router.post("/productnotes/create", productnoteController.create);
      Router.get("/productnotes/get", productnoteController.index);
      Router.patch("/productnotes/update/{id}", productnoteController.update);
      Router.delete("/productnotes/delete/{id}", productnoteController.destroy);

      Router.post("/vendor/create", vendorController.create);
      Router.get("/vendor/get", vendorController.index);
      Router.patch("/vendor/update/{id}", vendorController.update);
      Router.delete("/vendor/delete/{id}", vendorController.destroy);

      Router.post('/customer/create', customerController.create);
      Router.get('/customer/get', customerController.index);
      Router.patch('/customer/update/{id}', customerController.update);
      Router.delete('/customer/delete/{id}', customerController.destroy);

      Router.post('/order/create', orderController.create);
      Router.get('/order/get', orderController.index);
      Router.patch('/order/update/{id}', orderController.update);
      Router.delete('/order/delete{id}', orderController.destroy);
    }, middleware: [AuthenticateMiddleware()]);

    Router.get("/hello-world", () {
      return Response.html('Hello World');
    }).middleware([HomeMiddleware()]);

    // Return error code 400
    Router.get('wrong-request',
            () => Response.json({'message': 'Hi wrong request'}))
        .middleware([ErrorResponseMiddleware()]);

    // Return Authenticated user data
    Router.get("/user", () {
      return Response.json(Auth().user());
    }).middleware([AuthenticateMiddleware()]);
  }
}
