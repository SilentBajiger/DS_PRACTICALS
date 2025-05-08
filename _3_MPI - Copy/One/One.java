import java.util.Scanner;

import mpi.MPI;

public class One{
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        Scanner sc = new Scanner(System.in);
        int rank = MPI.COMM_WORLD.Rank();

        int number_of_processes = MPI.COMM_WORLD.Size();

        int no_of_ele_for_each_process = 5;
        int root = 0;

        int[] sending_buffer = new int[no_of_ele_for_each_process * number_of_processes];
        int[] receiving_buffer = new int[no_of_ele_for_each_process];
        int[] intermediate_sum_buffer = new int[number_of_processes];

        if(root == rank){
            System.out.println("Generating All the values automatically...");
            for(int i = 0 ; i < no_of_ele_for_each_process * number_of_processes  ;i++){
                System.out.print(i+",");
                sending_buffer[i] = i;
            }
        }

        MPI.COMM_WORLD.Scatter(
            sending_buffer,0,no_of_ele_for_each_process,MPI.INT,
            receiving_buffer,0,no_of_ele_for_each_process,MPI.INT,
            root
        );

        int[] local_buffer = new int[1];
        for(int i = 0 ; i < no_of_ele_for_each_process ; i++){
            local_buffer[0] += receiving_buffer[i];
        }
        System.out.println("Intermediate Result of processs: " + rank +" = " +local_buffer[0]);

        MPI.COMM_WORLD.Gather(
            local_buffer,0,1,MPI.INT,
            intermediate_sum_buffer,0,1,MPI.INT,
            root
        );

        if(rank == root){
            int sum = 0;
            for(int i = 0 ; i < number_of_processes ; i++){
                sum += intermediate_sum_buffer[i];
            }
            System.out.println("Final Sum:"+sum);
        }

        MPI.Finalize();

    }
}
