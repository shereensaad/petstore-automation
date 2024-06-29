package services;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.models.Pet;

public class PetStoreServices {

        private static final String BASE_URL = "https://petstore.swagger.io/v2";

        public PetStoreServices() {
            RestAssured.baseURI = BASE_URL;
        }

        public Response addPet(Pet pet) {
            return RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(pet)
                    .when()
                    .post("/pet");
        }

        public Response getPetById(int petId) {
            return RestAssured.given()
                    .pathParam("petId", petId)
                    .when()
                    .get("/pet/{petId}");
        }

        public Response updatePet(Pet pet) {
            return RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(pet)
                    .when()
                    .put("/pet");
        }

        public Response deletePet(int petId) {
            return RestAssured.given()
                    .pathParam("petId", petId)
                    .when()
                    .delete("/pet/{petId}");
        }
    }

