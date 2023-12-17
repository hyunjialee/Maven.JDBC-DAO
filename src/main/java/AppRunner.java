import daos.CarDAO;
import models.CarDTO;

public class AppRunner {

    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO();

        CarDTO car = new CarDTO();

        car.setId(1);
        car.setMake("Lexus");
        car.setModel("XYZ");
        car.setYear("2023");
        car.setColor("blue");
        car.setVin(123);

        CarDTO car2 = new CarDTO();
        car2.setId(2);
        car2.setMake("Mazda");
        car2.setModel("XYZ");
        car2.setYear("2022");
        car2.setColor("black");
        car2.setVin(124);

//        carDAO.create(car);
//        carDAO.create(car2);
        //created cars into the table

//        carDAO.update(car);
        //updated the car object to a different color

//        carDAO.delete(1);
        // deletes by the car_id

        System.out.println(carDAO.findById(1));
        System.out.println(carDAO.findById(2));

        System.out.println(carDAO.findAll());

    }
}
