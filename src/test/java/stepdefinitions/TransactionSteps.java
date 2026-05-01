package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import models.TransactionRequest;
import services.WompiService;

public class TransactionSteps {

    WompiService service;
    Response response;
    TransactionRequest request;

    @Given("que tengo datos de pago válidos")
    public void datos_validos() {
        service = new WompiService();

        request = new TransactionRequest();
        request.amount_in_cents = 5000000;
        request.currency = "COP";
        request.customer_email = "test@test.com";

        TransactionRequest.PaymentMethod pm = new TransactionRequest.PaymentMethod();
        pm.type = "PSE";

        request.payment_method = pm;
    }

    @When("creo una transacción con PSE")
    public void crear_transaccion() {
        response = service.createTransaction(request);
    }

    @When("envío la solicitud sin autenticación")
    public void sin_autenticacion() {
        response = service.createTransactionWithoutAuth(request);
    }

    @When("envío una transacción con monto {int}")
    public void monto_invalido(int monto) {
        request.amount_in_cents = monto;
        response = service.createTransaction(request);
    }

    @Then("el código de respuesta debe ser {int}")
    public void validar_respuesta(int status) {
        response.then().statusCode(status);
    }
}