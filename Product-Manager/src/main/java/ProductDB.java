import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection conn=null;

    public ProductDB(){
        try {
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_product","postgres","123456789");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(Product p) {
        String query="insert into product (name,type,place,warranty) values(?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,p.getName());
            ps.setString(2,p.getType());
            ps.setString(3,p.getPlace());
            ps.setInt(4,p.getWarranty());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        List<Product> product=new ArrayList<>();
        String query="select name,type,place,warranty from  product";
        try {
            PreparedStatement ps=conn.prepareStatement(query);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                product.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public Product getProduct(String name) {
        String query="select name,type,place,warranty from  product where name = ?";
        try {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,name);
            ResultSet rs =ps.executeQuery();
            Product p=new Product();
            while(rs.next()){

                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
            }
            return p;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
