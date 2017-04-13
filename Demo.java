/**
 *
 * @author chathura
 */
import java.io.*;
import java.util.*;
import java.util.regex.*;
class Demo{
	public static void main(String args[])throws IOException{
            Scanner in_partition = new Scanner(System.in);
            System.out.print("Driver letter : ");
            String driver = in_partition.nextLine();
            driver.trim();
            if(driver.matches("^[a-zA-Z]$")){
            driver = driver+":/";
            File ff = new File(driver);
            Scanner input = new Scanner(System.in);
            System.out.print("Input searching : ");
            String search=input.nextLine();
            ArrayList<String> searchList = new ArrayList<>();
            File[] mainFiles=ff.listFiles();
            LinkedList<String> filePath=new LinkedList<>();
            LinkedList<File> arrayFiles=new LinkedList<>();
                if(!(mainFiles==null)){
                for(File f : mainFiles){
                if(f.isFile()){
                String tempCompare=f.getAbsolutePath();
                tempCompare=tempCompare.replace("\\","\\\\");
                Pattern p=Pattern.compile(search);		
                Matcher m=p.matcher(tempCompare);
                if(m.find()){
                        tempCompare=tempCompare.replace("\\\\","\\");
                        searchList.add(tempCompare);
                  }
                }else{
                        arrayFiles.add(f);
                        }
                }
                }//
                    int e=arrayFiles.size();
                    while(e>0){
                        int c=arrayFiles.size();
                        for(int b=c;b>0;b--){
                            File tempFile=arrayFiles.get(b-1);
                            String virus=tempFile.getAbsolutePath();
                            File[] tempList=tempFile.listFiles();
                            if(!(tempList==null)){
                            for(File f : tempList){
                                    if(f.isFile()){
                                        String tempCompare=f.getAbsolutePath();
                                        tempCompare=tempCompare.replace("\\","\\\\");
                                        Pattern p=Pattern.compile(search);		
                                        Matcher m=p.matcher(tempCompare);
                                        if(m.find()){
                                            tempCompare=tempCompare.replace("\\\\","\\");
                                            searchList.add(tempCompare);
                                                }
                                                }else{
                                                arrayFiles.add(f);
                                                        }
                                                                }
                                                                }//
                                                arrayFiles.remove(b-1);// remove
                                                }
                                                e=arrayFiles.size();
                                }
					int x=0;	
			for(String c : searchList){
				System.out.println(c);
				x++;
				}	
			System.out.println(x+" files was found");	
		}else{
                System.err.println("Pleace input correctly driever...");
            }
            }
	}


