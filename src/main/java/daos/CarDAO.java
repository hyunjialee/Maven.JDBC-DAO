package daos;

import models.CarDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements CarDAOInterface {

    //Using it to get info from database
    @Override
    public Object findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement state = connection.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM carTable WHERE car_id=" + id);


            if (result.next()) {
                CarDTO car = new CarDTO();

                car.setId(result.getInt("car_id"));
                car.setMake(result.getString("make"));
                car.setModel(result.getString("model"));
                car.setYear(result.getString("year"));
                car.setColor(result.getString("color"));
                car.setVin(result.getInt("vin"));

                return car;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement state = connection.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM carTable");

            List<CarDTO> list = new ArrayList<>();

            while (result.next()) {
                CarDTO car = new CarDTO();

                car.setId(result.getInt("car_id"));
                car.setMake(result.getString("make"));
                car.setModel(result.getString("model"));
                car.setYear(result.getString("year"));
                car.setColor(result.getString("color"));
                car.setVin(result.getInt("vin"));

                list.add(car);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object update(Object dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE carTable SET make=?,model=?,year=?,color=?,vin=? WHERE car_id=?");
            ps.setString(1, ((CarDTO) dto).getMake());
            ps.setString(2, ((CarDTO) dto).getModel());
            ps.setString(3, ((CarDTO) dto).getYear());
            ps.setString(4, ((CarDTO) dto).getColor());
            ps.setInt(5, ((CarDTO) dto).getVin());
            ps.setInt(6, ((CarDTO) dto).getID());
            int i = ps.executeUpdate();

            if (i == 1) {
                return dto;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Object create(Object dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO carTable(car_id,make, model, year, color, vin) VALUES (?,?,?,?,?,?)");
            ps.setInt(1, ((CarDTO) dto).getID());
            ps.setString(2, ((CarDTO) dto).getMake());
            ps.setString(3, ((CarDTO) dto).getModel());
            ps.setString(4, ((CarDTO) dto).getYear());
            ps.setString(5, ((CarDTO) dto).getColor());
            ps.setInt(6, ((CarDTO) dto).getVin());

            int i = ps.executeUpdate();
            if (i == 1) {
                return dto;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement state = connection.createStatement();
            state.executeUpdate("DELETE FROM carTable WHERE car_id=" + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
