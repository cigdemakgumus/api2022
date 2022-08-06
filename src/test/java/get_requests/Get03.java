package get_requests;

import base_Urls.BaseUrls;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03 extends BaseUrls {
    /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
   */

    @Test
    public void get01() {
        // 1) Set the URL (URl'yi kurmak)
        //   String url = "https://jsonplaceholder.typicode.com/todos/23";
        //   spec.pathParams("first","todos","second",23); // first second ne yazdigimiz onemli degil ama daha sonra da ayni isimle kullanmaliyiz. genelde boyle kullanilir

        spec.pathParams("first","todos","second",23);
        // 2) Set the expected Data (beklenen datanın oluşturulması) (POST - PUT - PATCH)

        // 3) Type code to send request (talep göndermek için kod yazma)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        // 4) Do Assertion (doğrulama yapma)
        // 1.yol
        response.then().assertThat().statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

        // 2.yol
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(2));

    }
/*
NOT-1:  Assertion yaparken java calismayi durdurdugunda hata sonrasi kodlar calismaz.
Boylece hata sonrasi asssertionlar hakkinda bilgi sahibi olamayiz.Fakat hata oncesi assertionlar gecmistir.
NOT-2: Eger kodumuz3u hata noktasinda duracak sekilde yazarsak "hard assertion" yapmis oluruz.


*/
}