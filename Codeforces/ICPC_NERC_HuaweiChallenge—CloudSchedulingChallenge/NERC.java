import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class NERC {

    /** 𝑆𝑐𝑜𝑟𝑒=1000⋅log10(𝑇𝑜𝑡𝑎𝑙_𝑠𝑡𝑒𝑝𝑠×𝑀𝑒𝑚𝑜𝑟𝑦_𝑚𝑜𝑣𝑒𝑑_𝑖𝑛_𝐺𝐵+1) */ 

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error, usage: java NERC.java input0.txt");
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

            // get the optimal mapping.
            // vm from server [x] to server [y] (same numbers of the VMs)
            // could be table data structure.
            int[] fstMove = new int[vmNumbers];
            int[] sndMove = new int[vmNumbers];
            for (int i = 0; i < vmNumbers; i++) {
                fstMove[i] = reader.nextInt();
                sndMove[i] = reader.nextInt();
            }
            // System.out.println(Arrays.toString(fstMove) + " : " + Arrays.toString(sndMove));
            
            /** TODO:
            1. n:= number of servers, not equal to their optimal configration;
            2. while n!=0:
                3. Choose any server out of n;
                4. Move out all VMs, that do not belong to be at this server:
                    5. Move VMs to their optimal place, if possible, or some host from n
                5. Move in all VMs, that must be here, but are not;
                6. n:=-1;
                7. GOTO 2;
            */

            int totalStepsCount = 0;
            while (vmNumbers != 0) {  // and vm not in their optimal resedency
                // for test case 1
                // move vm from 0 to server 1
                for (int i = 0; i < sndMove.length; i++) {
                    
                }

                vmNumbers--;
            }
            


        } catch (Exception e) {
            System.out.println("file error: " + e);
        }
    }
    

    static void megrate() {

    }
}