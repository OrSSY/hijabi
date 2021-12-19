import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerMain {
    static Pelanggan pelanggan;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    public static void main(String[] args) {
        try {
            pelanggan = new Pelanggan();
            ResultSet viewcust = pelanggan.getPelanggan();
            System.out.println("====== WELCOME PELANGGAN =======");
            System.out.println("1. Registrasi \n" +
                    "2. Login \n" +
                    "Pilih menu anda: ");
            String login = input.readLine().trim();
            if (login.equals("1")){
                System.out.println("===== REGISTRASI AKUN =====");
                pelanggan.addCustomer();
            }
            else if (login.equals("2")) {
                System.out.println("Masukkan username: ");
                String username = input.readLine().trim();
                System.out.print("Password: ");
                String password = input.readLine().trim();
                String coba = "try";
                if (!viewcust.wasNull()) {
                    while (viewcust.next()) {
                        if (username.equals(viewcust.getString("username")) && (password.equals(viewcust.getString("password")))) {
                            while(true){
                            System.out.println("Menu: \n" +
                                    "1. Pesan \n" +
                                    "2. Lihat Status Pesanan \n" +
                                    "3. Lihat Hijab \n" +
                                    "4. Keluar \n" +
                                    "Menu yang ingin dipilih: ");
                            String opsi = input.readLine().trim();
                            if (opsi.equals("4")) {
                                break;
                            } else {
                                switch (opsi) {
                                    case "1":
                                        pelanggan.addPesanan();
                                        break;
                                    case "2":
                                        viewStatus();
                                        break;
                                    case "3":
                                        viewHijab();
                                        break;
                                    default:
                                        System.out.println("Menu Tidak Ada");
                                        break;
                                    }
                                }
                            }
                        } else {
                            coba = "catch";
                        }
                    }
                }
            if (coba.equals("catch")){
                System.out.println("Gagal Login");
            }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void viewStatus () throws SQLException {
        ResultSet viewstatus = pelanggan.getStatus();
        System.out.println("ID Status   ID Pesanan    Status");
        while (viewstatus.next()) {
            System.out.print(viewstatus.getString("id_status_pesanan"));
            System.out.print("  |  ");
            System.out.print(viewstatus.getString("id_pesanan"));
            System.out.print("  |  ");
            System.out.print(viewstatus.getString("status_pesanan"));
            System.out.println("  |  ");
        }

    }
    public static void viewHijab () throws SQLException {
        ResultSet viewhijab = pelanggan.getHijab();
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
}
