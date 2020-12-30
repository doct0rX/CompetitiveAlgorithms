import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class NERC {

    /** 𝑆𝑐𝑜𝑟𝑒=1000⋅log10(𝑇𝑜𝑡𝑎𝑙_𝑠𝑡𝑒𝑝𝑠×𝑀𝑒𝑚𝑜𝑟𝑦_𝑚𝑜𝑣𝑒𝑑_𝑖𝑛_𝐺𝐵+1) */ 

    /**
     * input
     * 2 1
     * 100 500
     * 200 1000
     * 50 200
     * 0 1
     *****
     * output:
     * 1
     * 1
     * 0 1 0
     * 
     */


    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error, usage: java ClassName inputfile");
            System.exit(1);
        }
        try {
            Scanner reader = new Scanner(new FileInputStream(args[0]));  
            
            // x - servers (specs i, j)
            // y - vms     (specs o, p)
            int serversNum = reader.nextInt();
            // System.out.println(serversNums);
            int vmNumbers = reader.nextInt();
            
            // servers have 2 lists [1st for GB, 2nd for RAM]
            int[] serverGB = new int[serversNum];
            int[] serverRM = new int[serversNum];
            for (int i = 0; i < serversNum; i++) {
                serverGB[i] = reader.nextInt();
                serverRM[i] = reader.nextInt();
            }

            // VMs have 2 lists [1st for GB, 2nd for RAM]
            int[] vmGB = new int[vmNumbers];
            int[] vmRM = new int[vmNumbers];
            for (int i = 0; i < vmNumbers; i++) {
                vmGB[i] = reader.nextInt();
                vmRM[i] = reader.nextInt();
            }
            // System.out.println(Arrays.toString(serverGB) + " : " + Arrays.toString(serverRM) + " : " + Arrays.toString(vmGB));

            // get the optimal mapping.
            // vm from server [x] to server [y] (same numbers of the VMs)
            // could be table data structure.
            for (int i = 0; i < vmNumbers; i++) {
                // vmGB[i] = reader.nextInt();
                // vmRM[i] = reader.nextInt();
            }


        } catch (Exception e) {
            System.out.println("file error: " + e);
        }
    }
    

    static void megrate() {

    }
}