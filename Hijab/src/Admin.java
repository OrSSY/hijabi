import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Admin extends Connect{
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    public Admin(){
        super();
    }

    public ResultSet getAdmin() throws SQLException {
        String query = "SELECT * from admin";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public int addHijab() throws SQLException, IOException {
        String query = "INSERT INTO hijab" + " (id_hijab, jenis_hijab, bahan_hijab, warna_hijab, panjang_hijab, lebar_hijab, stok, harga, id_admin, create_at, update_at) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?::date, ?::date)";

        System.out.println("Masukkan ID hijab: ");
        String idhijab= input.readLine().trim();
        System.out.print("Masukkan jenis hijab: ");
        String jenis = input.readLine().trim();
        System.out.print("Masukkan bahan hijab");
        String bahan = input.readLine().trim();
        System.out.print("Masukkan warna hijab: ");
        String warna = input.readLine().trim();
        System.out.print("Masukkan panjang hijab: ");
        int panjang = Integer.parseInt(input.readLine());
        System.out.print("Masukkan lebar hijab: ");
        int lebar = Integer.parseInt(input.readLine());
        System.out.print("Masukkan stok: ");
        int stok = Integer.parseInt(input.readLine());
        System.out.print("Masukkan harga: ");
        int harga = Integer.parseInt(input.readLine());
        System.out.print("Masukkan ID Admin: ");
        String idadmin = input.readLine().trim();
        System.out.print("Masukkan tanggal ditambah: ");
        String tambah = input.readLine().trim();
        System.out.print("Masukkan tanggal diupdate: ");
        String update = input.readLine().trim();



        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, idhijab);
        preparedStatement.setString(2, jenis);
        preparedStatement.setString(3, bahan);
        preparedStatement.setString(4, warna);
        preparedStatement.setInt(5, panjang);
        preparedStatement.setInt(6, lebar);
        preparedStatement.setInt(7, stok);
        preparedStatement.setInt(8, harga);
        preparedStatement.setString(9, idadmin);
        preparedStatement.setDate(10, Date.valueOf(tambah));
        preparedStatement.setDate(11, Date.valueOf(update));

        return preparedStatement.executeUpdate();

    }
    public ResultSet getHijab() throws SQLException {
        String query = "SELECT * from hijab";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public int upHijab() throws SQLException, IOException {
        String query = "UPDATE hijab " + "SET jenis_hijab = ?, bahan_hijab = ?, warna_hijab = ?, panjang_hijab = ?, lebar_hijab = ?, stok = ?, harga = ?, id_admin = ?, create_at = ?::date, update_at = ?::date where id_hijab = ?";

        System.out.println("Masukkan ID hijab yang ingin diubah: ");
        String idhijab= input.readLine().trim();
        System.out.print("Masukkan jenis hijab: ");
        String jenis = input.readLine().trim();
        System.out.print("Masukkan bahan hijab");
        String bahan = input.readLine().trim();
        System.out.print("Masukkan warna hijab: ");
        String warna = input.readLine().trim();
        System.out.print("Masukkan panjang hijab: ");
        int panjang = Integer.parseInt(input.readLine());
        System.out.print("Masukkan lebar hijab: ");
        int lebar = Integer.parseInt(input.readLine());
        System.out.print("Masukkan stok: ");
        int stok = Integer.parseInt(input.readLine());
        System.out.print("Masukkan harga: ");
        int harga = Integer.parseInt(input.readLine());
        System.out.print("Masukkan ID Admin: ");
        String idadmin = input.readLine().trim();
        System.out.print("Masukkan tanggal ditambah: ");
        String tambah = input.readLine().trim();
        System.out.print("Masukkan tanggal diupdate: ");
        String update = input.readLine().trim();



        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, jenis);
        preparedStatement.setString(2, bahan);
        preparedStatement.setString(3, warna);
        preparedStatement.setInt(4, panjang);
        preparedStatement.setInt(5, lebar);
        preparedStatement.setInt(6, stok);
        preparedStatement.setInt(7, harga);
        preparedStatement.setString(8, idadmin);
        preparedStatement.setDate(9, Date.valueOf(tambah));
        preparedStatement.setDate(10, Date.valueOf(update));
        preparedStatement.setString(11, idhijab);
        return preparedStatement.executeUpdate();

    }
    public void delHijab() throws SQLException, IOException{
        System.out.print("ID Hijab yang akan dihapus: ");
        int id = Integer.parseInt(input.readLine());
        String query = "DELETE from hijab where id_hijab=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

    }
    public int upStatusPesanan() throws SQLException, IOException {
        String query = "UPDATE status_pesanan " +
                "SET id_pesanan = ?, status_pesanan = ? where id_status_pesanan = ?";
        System.out.print("Masukkan ID Status yang ingin diubah: ");
        String idStatus = input.readLine().trim();
        System.out.print("Masukkan ID Pesanan: ");
        String idPesanan = input.readLine().trim();
        System.out.print("Masukkan status pesanan: ");
        String status = input.readLine().trim();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, idStatus);
        preparedStatement.setString(2, idPesanan);
        preparedStatement.setString(3, status);
        return preparedStatement.executeUpdate();

    }
    public ResultSet getPelanggan() throws SQLException {
        String query = "SELECT * from pelanggan";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }






}
