import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        int N = sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
        arr[i]=sc.nextInt();
        
        int target=sc.nextInt();

        Accio ob = new Accio();
        int ans= ob.findElement(arr, N,target);

        System.out.println(ans);
    
    }
}


class Accio {
    static int findElement(int arr[], int n,int target)
    {
        // your code here

        int index=findBitonicPoint(arr,n,0,n-1);

        int ans=searchBitonic(arr,n,target,index);

        return ans;


    }


    static int ascendingBinarySearch(int arr[],int low,int high,int key)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }
            if (arr[mid] > key)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
 
    static int descendingBinarySearch(int arr[],int low,int high,int key)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }
            if (arr[mid] < key)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int findBitonicPoint(int arr[],int n,int l,int r)
    {
        int mid;
        int bitonicPoint = 0;
        mid = (r + l) / 2;
        if (arr[mid] > arr[mid - 1]
            && arr[mid] > arr[mid + 1])
        {
            return mid;
        }
        else {
            if (arr[mid] > arr[mid - 1]
                && arr[mid] < arr[mid + 1])
            {
                bitonicPoint = findBitonicPoint(arr, n, mid, r);
            }
            else {
                if (arr[mid] < arr[mid - 1]
                    && arr[mid] > arr[mid + 1])
                {
                    bitonicPoint = findBitonicPoint(arr, n, l, mid);
                }
            }
        }
        return bitonicPoint;
    }

    static int searchBitonic(int arr[], int n,int key, int index)
    {
        if (key > arr[index])
        {
            return -1;
        }
        else if (key == arr[index])
        {
            return index;
        }
        else {
            int temp = ascendingBinarySearch(
                arr, 0, index - 1, key);
            if (temp != -1)
            {
                return temp;
            }

            return descendingBinarySearch(arr, index + 1,
                                        n - 1, key);
        }
    }
}
