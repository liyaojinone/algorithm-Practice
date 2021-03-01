package Find;

/**
 * @author jion
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a={1,4,6,7,24,77,99,105};
        System.out.println("binary(2,a) = " + binary(77, a));
    }
    private static int binary(int obj, int[] args){
        int left=0;
        int mid = 0;
        int end=args.length-1;
        while (left<=end){
            //二分查找mid=left + 1/2(end-left);
//            mid=left+(end-left)/2;
            //插值查找    mid=left + “(obj-args[left]) / (args[end]-args[left])” * (end-left);加权
            mid=left+(obj-args[left]) / (args[end]-args[left]) * (end-left);
            if (obj==args[mid]){
                return mid;
            }else if (obj<args[mid]){
                end=mid-1;
            }else if (obj>args[mid]){
                left=mid+1;
            }else {
                return -1;
            }
        }
        return -1;
    }
}
