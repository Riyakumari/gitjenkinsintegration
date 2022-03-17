import java.io.*;
import java.util.*;

class ProductDescription{
	public String ID,color,size, gender, name, availability;
	public Float price,rating;

	ProductDescription(String ID, String name, String color, String gender, String size,Float price, Float rating,String availability){

		this.ID=ID;
		this.name=name;
		this.gender=gender;
		this.size=size;
		this.color=color;
		this.price=price;
		this.availability=availability;
		this.rating=rating;
	}

}

class CSVReader{
	ArrayList<ProductDescription> Shirt=new ArrayList<ProductDescription>();
	ArrayList<String>csvData;
	public void readProduct(String csvFile,String color, String gender, String size, int choice) throws FileNotFoundException{
		Scanner sc=new Scanner(new File(csvFile));
		while(sc.hasNext()) {
			String record=sc.nextLine().toString().toUpperCase();
			if(!record.isEmpty()) {
				StringTokenizer token=new StringTokenizer(record,"|");
				csvData=new ArrayList<String>(token.countTokens());
				while(token.hasMoreTokens()) {
					csvData.add(token.nextToken());
				}
				if(csvData.get(2).equalsIgnoreCase(color)&&csvData.get(3).equalsIgnoreCase(gender)&&csvData.get(4).equalsIgnoreCase(size)&&csvData.get(7).equalsIgnoreCase("Y")) {
					ProductDescription desc=new ProductDescription(csvData.get(0),csvData.get(1),csvData.get(2),csvData.get(3),csvData.get(4),Float.parseFloat(csvData.get(5)),Float.parseFloat(csvData.get(6)),csvData.get(7));
					Shirt.add(desc);
				}
			}
		}

	}
	public void modifyView(int choice) {
		if(choice==1) {
			Collections.sort(Shirt,new Comparator<ProductDescription>() {
				public int compare(ProductDescription m1,ProductDescription m2) {
					return (int)(m2.price-m1.price);
				}
			}); 

		}else if(choice==2) {
			Collections.sort(Shirt,new Comparator<ProductDescription>() {
				public int compare(ProductDescription m1,ProductDescription m2) {
					return (int)(m2.rating-m1.rating);
				}
			});
		}else if(choice==3){
			Collections.sort(Shirt,new Comparator<ProductDescription>() {
				public int compare(ProductDescription m1, ProductDescription m2) {
					if(m1.price==m2.price) {
						return (int)(m2.rating-m1.rating);
					}
					else {
						return (int)(m1.price-m2.price);
					}

				}
			});
		}
	}
	public void display() {
		if(Shirt.size()==0) {
			System.out.println("...Out of Stock!!!...");
		}else {
			for(ProductDescription f:Shirt) {
				System.out.print("ID:-"+f.ID);
				System.out.print(" Model Name:-"+f.name);
				System.out.print(" Size:-"+f.size);
				System.out.print(" Color:-"+f.color);
				System.out.print(" Price:-"+f.price);
				System.out.print(" Rating"+f.rating);
				System.out.println("");
			}
		}
	}
}
public class Product_Enquiry {

	public static void main(String[] args)throws FileNotFoundException {
		Scanner sc=new Scanner(System.in);	
		String gender, size,color,ch="y";
		int choice;
		loop1:while(ch.equalsIgnoreCase("y")) {
			System.out.println("Enter the color of Tshirt: ");
			color=sc.next();
			System.out.println("Enter the size: ");
			size=sc.next();
			System.out.println("Enter the gender (M/F/U):");
			gender=sc.next();
			if(!(gender.equalsIgnoreCase("m")||gender.equalsIgnoreCase("f")||gender.equalsIgnoreCase("u")))
			{
				System.out.println("Invalid gender!!!");
				continue loop1;
			}
			System.out.println("Enter your output preference-\n1.Sort by price.\n2. Sort by rating.\n3. Sort by price and rating.");
			choice=sc.nextInt();
			if(!(choice==1||choice==2||choice==3))
			{
				System.out.println("Invalid choice!!!");
				continue loop1;
			}
			CSVReader cr=new CSVReader();
			String path="src/main/resources";
			File [] file=new File(path).listFiles(new FileFilter() {
				public boolean accept(File path) {
					if(path.isFile()) {
						return true;
					}
					return false;
				}
			});

			for(int i=0;i<file.length;i++) {
				if(file[i].isFile())
					cr.readProduct(file[i].toString(), color, gender, size, choice);
			}
			cr.modifyView(choice);
			cr.display();
			System.out.println("Want to search for more(Y/N):");
			ch=sc.next();
		}

	}

}
