import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Pelanggan extends Connect{
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    public Pelanggan(){
        super();
    }
    public int addCustomer() throws SQLException, IOException {
        String query = "INSERT INTO pelanggan" + " (id_pelanggan, nama_lengkap, tanggal_lahir, jenis_kelamin, alamat, no_hp, username, password) " + "VALUES (?, ?, ?::date, ?, ?, ?, ?, ?)";

        System.out.println("Masukkan ID Pelanggan: ");
        String idPel= input.readLine().trim();
        System.out.print("Masukkan nama lengkap: ");
        String nama = input.readLine().trim();
        System.out.print("Masukkan tanggal lahir");
        String tanggal = input.readLine().trim();
        System.out.print("Masukkan jenis kelamin: ");
        String jenis = input.readLine().trim();
        System.out.print("Masukkan alamat: ");
        String alamat = input.readLine().trim();
        System.out.print("Masukkan nomer hp: ");
        String nohp = input.readLine().trim();
        System.out.print("Masukkan username: ");
        String username = input.readLine().trim();
        System.out.print("Masukkan password: ");
        String pass = input.readLine().trim();



        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, idPel);
        preparedStatement.setString(2, nama);
        preparedStatement.setDate(3, Date.valueOf(tanggal));
        preparedStatement.setString(4, jenis);
        preparedStatement.setString(5, alamat);
        preparedStatement.setString(6, nohp);
        preparedStatement.setString(7, username);
        preparedStatement.setString(8, pass);

        return preparedStatement.executeUpdate();

    }
    public ResultSet getPelanggan() throws SQLException {
        String query = "SELECT * from pelanggan";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public void addPesanan() throws SQLException, IOException {
        String query = "INSERT INTO pesanan" + " (id_pesanan, id_pelanggan, create_at) " + "VALUES (?, ?, ?::date );" +
                "INSERT INTO status_pesanan" + "(id_status_pesanan, id_pesanan, status_pesanan) values (?, ?, ?)";
        System.out.print("Masukkan ID pesanan: ");
        String idOrd = input.readLine().trim();
        System.out.print("Masukkan ID Pelanggan: ");
        String  idCust = input.readLine().trim();
        System.out.print("Tanggal pembelian: ");
        String tanggal = input.readLine().trim();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, idOrd);
        preparedStatement.setString(2, idCust);
        preparedStatement.setDate(3, Date.valueOf(tanggal));
        preparedStatement.setString(4, idOrd);
        preparedStatement.setString(5, idOrd);
        preparedStatement.setString(6, "Pesanan Diterima");



        preparedStatement.executeUpdate();
    }
    public ResultSet getStatus() throws SQLException {
        String query = "SELECT * from status_pesanan";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public ResultSet getHijab() throws SQLException {
        String query = "SELECT * from hijab";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

}
