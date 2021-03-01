Arrays.sort(T[] arr, Comparator<T> c){
    for(int i = 0; i < arr.length; ++i){
        for(int j = i + 1; j < arr.length; ++j){
            if(c.compare(arr[i] , arr[j]) > 0){
                //....
            }
        }
    }
}

Arrays.sort(arr, (a, b) -> b - a);

class aaa implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b){
        return b - a;
    }
}

interface Comparator<T>{
    public int compare(T a, T b);
}