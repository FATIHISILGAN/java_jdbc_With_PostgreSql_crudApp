package pg_bağlantı;

import java.sql.Connection;//bağlantı lib
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class new_jdbc {

	public static final String cs = "jdbc:postgresql://localhost/jdbc_ödev";
	public static final String db_userName="postgres";
	public static final String db_userPassword="projesqlpw321";
	
	public static Connection bağlımı =null;
	public  static Statement stmt=null;
	public static String sqlCümlesi=null;
	
	 public static void  arama() {
		 try {
			Scanner sc =new Scanner(System.in);
			 System.out.println("ne aramak istiyorsunuz(öğrenciler,fakülteler) şeklinde cevap veriniz ");
			 String seçim=sc.next();
			 System.out.println("aramak istediğiniz id:");
			 
			 
			String id=sc.next();
			
			 
			sqlCümlesi = "SELECT * FROM public.\""+seçim+"\" WHERE id = " + id; stmt = 
					bağlımı.createStatement(); 
			ResultSet Rs =stmt.executeQuery(sqlCümlesi);
			 if (Rs.next()) { 
			 System.out.println("ID = " + Rs.getInt(1)); System.out.println("ad = " + Rs.getString(2));
			 System.out.println("soyad = " + Rs.getString(3));    }
			 else { System.out.println(">» Bu ID'de Bir Kayit Bulunmamaktadir!"); 
			 Rs.close(); stmt.close(); 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		 
	 }	
public static void listele() {
		
		try {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("hangi tabloyu listeleyeceksiniz(öğrenciler,fakülteler)");
			
			String seçim=sc.next();
			
			PreparedStatement stmt=bağlımı.prepareStatement("Select * from "+seçim);
			ResultSet Rs=stmt.executeQuery();
			System.out.println("seçtiğiniz tablonun kayıtları:");
			
			try{
				
			while(Rs.next()) {
								
							
				System.out.println(Rs.getString(1)+" "+Rs.getString(2)+" "+Rs.getString(3));
			}
			

			}
			catch(Exception e){
				
				
			}
			finally {
				while(Rs.next()) {
					
					
					System.out.println(Rs.getString(1)+" "+Rs.getString(2));
				}
			}
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
		}
	}
public static void güncelle() {
		
		try {
			Scanner sc=new Scanner (System.in);
			 
			System.out.println("neyi güncelleyeceksin (öğrenciler)");
			
			String seçim=sc.next();
			
			System.out.println("id gir: ");
			
			String id=sc.next();
			
			System.out.println("ad ,soyad ");
			
			String seçim2=sc.next();
			
			System.out.println("yeni adı girin:");
			
			String yeni=sc.next();
			
			
			sqlCümlesi="update "+seçim+" set "+seçim2+"=" +"'"+ yeni+"' where id="+id+";" ;// hata var
			
			
			stmt=bağlımı.createStatement();
			
			stmt.executeUpdate(sqlCümlesi);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
public static void ekle() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ne eklemek istiyorsunuz ?(öğrenciler,fakülteler ) cevabını veriniz ");
		
	String seçim= sc.next();
	
	String id="",ad="",soyad="",fakülteid="";
	String fakültead ="";
	
	
	
	if(seçim.equals("öğrenciler")) {
		try {
		System.out.println("id gir:");
		id=sc.next();
		
		System.out.println("ad gir:");
		ad=sc.next();
		System.out.println("soyad gir:");
		soyad=sc.next();
		System.out.println(" fakülte id gir:");
		fakülteid=sc.next();
		
		sqlCümlesi="Insert Into public.\"öğrenciler\" (id,ad,soyad,fakülteid)  Values"+"("+id+","+"'"+ad+"'"+","+"'"+soyad+"'"+","+fakülteid+");";
		
		
			stmt=bağlımı.createStatement();
			
			stmt.executeUpdate(sqlCümlesi);
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	else if(seçim.equals("fakülteler")) {
		
		try {
			System.out.println("id gir:");
			id=sc.next();
			
			System.out.println(" fakülte ad gir:");
			fakültead=sc.next();
			
			
			sqlCümlesi="Insert Into public.\"fakülteler\" (id,ad)  Values"+"("+id+","+"'"+ad+"'"+");";
			
			
				stmt=bağlımı.createStatement();
				
				stmt.executeUpdate(sqlCümlesi);
				
				stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	}

		
	}
	public static void Menu() {

		System.out.println("Öğrenci bilgi sistemine hoş geldiniz:");
		
		System.out.println("menü:");
		System.out.println("lütfen ilgili numaralar ile işleminizi seçiniz( örnek:1,2,3,4)");
		System.out.println("1-ekleme");//
		System.out.println("2-silme");//
		System.out.println("3-güncelleme");//
		System.out.println("4-listele");
		System.out.println("5-arama");//
		
	}
	
public  static void bağlan() {
		
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			bağlımı=DriverManager.getConnection(cs,db_userName,db_userPassword);
			
			
			if(bağlımı!=null) {
				
				System.out.println("bağlandı");
			}
			
			else {
				
				System.out.println("bağlanamadı");// çökme yok ama bağlanmadı
			}
			
			
			
		}catch(Exception e){
			System.out.println("bir sıkıntı var mesaj:");//çökme var
			System.out.println(e.getMessage());//sorun nedir
		}
		
	}
	
public static void sil() {
	Scanner sc=new Scanner(System.in);
	
	String seçim="";
	
	System.out.println("neyi silmek istiyorsunuz (öğrenciler,fakülteler) ");
	seçim=sc.next();
	String id="";
	
	if(seçim.equals("öğrenciler")) {
	
	try {
		
		   System.out.println("silinecek öğrencinin id si:");
		   
		   id= sc.next();
		   
			sqlCümlesi="Delete From public.\"öğrenciler\" Where id= "+id+";";
			
			
			
				stmt=bağlımı.createStatement();
				
				stmt.executeUpdate(sqlCümlesi);
				
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	else if(seçim.equals("fakülteler")) {
		
		try {
			
			   System.out.println("silinecek fakültenin id si:");
			   
			   id= sc.next();
			   
				sqlCümlesi="Delete From public.\"fakülteler\" Where id= "+id+";";
				
				
				
					stmt=bağlımı.createStatement();
					
					stmt.executeUpdate(sqlCümlesi);
					
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

else {

System.out.println("böyle bir seçim yok");
}
}

	public static void main(String[] args) {
		
		

		
		Scanner scanner=new Scanner(System.in);
		
		String seçim=" ";
		bağlan();
		
		while(!seçim.equals("q")){
			
			Menu();
			
			seçim=scanner.next();
			
			
			if(seçim.equals("1")) {
				
				
				ekle();
			}
			else if (seçim.equals("2")) {
				
				sil();
			}
			
	else if (seçim.equals("3")) {
				
			 güncelle();
			}
	else if (seçim.equals("4")) {
		
		 listele();
		}
			
	else if (seçim.equals("5")) {
		
		 arama();
		}
		}
		
		 
	}

}
