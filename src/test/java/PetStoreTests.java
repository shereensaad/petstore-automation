import utils.models.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import services.PetStoreServices;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetStoreTests {

    private static PetStoreServices petStoreServices;
    private static Pet pet;

    @BeforeAll
    public static void setup() {
        petStoreServices = new PetStoreServices();

        Pet.Category category = new Pet.Category();
        category.setId(1);
        category.setName("Dogs");

        Pet.Tag tag = new Pet.Tag();
        tag.setId(1);
        tag.setName("Tag1");

        pet = new Pet();
        pet.setId(123456);
        pet.setName("Melo");
        pet.setCategory(category);
        pet.setPhotoUrls(new String[]{"http://example.com/photo1.jpg"});
        pet.setTags(new Pet.Tag[]{tag});
        pet.setStatus("available");
    }

    @Test
    @Order(1)
    public void testAddNewPet() {
        Response response = petStoreServices.addPet(pet);
        response.then().statusCode(200);

        Pet responsePet = response.as(Pet.class);
        assertThat(responsePet.getId(), equalTo(pet.getId()));
        assertThat(responsePet.getName(), equalTo(pet.getName()));
        assertThat(responsePet.getStatus(), equalTo(pet.getStatus()));
    }

    @Test
    @Order(2)
    public void testGetPetById() {
        petStoreServices.addPet(pet);
        Response response = petStoreServices.getPetById(pet.getId());
        response.then().statusCode(200);

        Pet responsePet = response.as(Pet.class);
        assertThat(responsePet.getId(), equalTo(pet.getId()));
        assertThat(responsePet.getName(), equalTo(pet.getName()));
        assertThat(responsePet.getStatus(), equalTo(pet.getStatus()));
    }

    @Test
    @Order(3)
    public void testUpdatePet() {
        pet.setName("Melo");
        pet.setStatus("sold");

        Response response = petStoreServices.updatePet(pet);
        response.then().statusCode(200);

        Pet responsePet = response.as(Pet.class);
        assertThat(responsePet.getId(), equalTo(pet.getId()));
        assertThat(responsePet.getName(), equalTo(pet.getName()));
        assertThat(responsePet.getStatus(), equalTo(pet.getStatus()));
    }

    @Test
    @Order(4)
    public void testDeletePet() {
        petStoreServices.deletePet(pet.getId());
        Response response= petStoreServices.getPetById(pet.getId());
        response.then().statusCode(404);

    }
    @AfterAll
    public static void cleanup() {
        petStoreServices.deletePet(pet.getId());
    }
}
