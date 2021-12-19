import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMain {
        static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        static BufferedReader input = new BufferedReader(inputStreamReader);
    static Admin admin;
    public static void main(String[] args) {
        try{
            admin = new Admin();
            ResultSet viewadmin =admin.getAdmin();
            System.out.println("====== WELCOME ADMIN =======");
            System.out.println("Masukkan username: ");
            String username = input.readLine().trim();
            System.out.print("Password: ");
            String password = input.readLine().trim();
            String coba = "try";
            if (!viewadmin.wasNull()) {
                while (viewadmin.next()) {
                        if (username.equals(viewadmin.getString("username")) && (password.equals(viewadmin.getString("password")))) {
                            while (true) {
                            System.out.println("Menu: \n" +
                                    "1. Tambah Hijab \n" +
                                    "2. Lihat Hijab \n" +
                                    "3. Edit Hijab \n" +
                                    "4. Hapus Hijab \n" +
                                    "5. Ubah Status \n" +
                                    "6. Lihat Pelanggan \n" +
                                    "7. Keluar \n" +
                                    "Menu yang ingin dipilih: ");
                            String opsi = input.readLine().trim();
                            if (opsi.equals("7")) {
                                break;
                            } else {
                                switch (opsi) {
                                    case "1":
                                        admin.addHijab();
                                        break;
                                    case "2":
                                        viewHijab();
                                        break;
                                    case "3":
                                        admin.upHijab();
                                        break;
                                    case "4":
                                        admin.delHijab();
                                        break;
                                    case "5":
                                        admin.upStatusPesanan();
                                        break;
                                    case "6":
                                        viewPelanggan();
                                        break;
                                    default:
                                        System.out.println("Menu Tidak Ada");
                                        break;
                                }
                            }
                        }
                    }
                    else {
                        coba = "catch";
                    }
                }
            }
            if (coba.equals("catch")){
                System.out.println("Gagal Login");
            }
                    } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
    public static void viewHijab () throws SQLException {
        ResultSet viewhijab = admin.getHijab();
        System.out.println("ID Hijab     Jenis      Bahan        Warna       Panjang     Lebar      Stok      Harga       ID Admin          Tanggal Dibuat          Tanggal Update");
        while (viewhijab.next()) {
            System.out.print(viewhijab.getString("id_hijab"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getString("jenis_hijab"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getString("bahan_hijab"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getString("warna_hijab"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getInt("panjang_hijab"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getInt("lebar_hijab"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getInt("stok"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getInt("harga"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getString("id_admin"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getString("create_at"));
            System.out.print("  |  ");
            System.out.print(viewhijab.getString("update_at"));
            System.out.println("  |  ");

        }

    }
    public static void viewPelanggan () throws SQLException {
        ResultSet viewpel = admin.getPelanggan();
        System.out.println("id_pelanggan, nama_lengkap, tanggal_lahir, jenis_kelamin, alamat, no_hp, username, password");
        while (viewpel.next()) {
            System.out.print(viewpel.getString("id_pelanggan"));
            System.out.print("  |  ");
            System.out.print(viewpel.getString("nama_lengkap"));
            System.out.print("  |  ");
            System.out.print(viewpel.getString("tanggal_lahir"));
            System.out.print("  |  ");
            System.out.print(viewpel.getString("jenis_kelamin"));
            System.out.print("  |  ");
            System.out.print(viewpel.getString("alamat"));
            System.out.print("  |  ");
            System.out.print(viewpel.getString("no_hp"));
            System.out.print("  |  ");
            System.out.print(viewpel.getString("username"));
            System.out.print("  |  ");
            System.out.print(viewpel.getString("password"));
            System.out.println("  |  ");
        }

    }
}
