int minimum(int *arr, int n){
    int mini = arr[0];
    for (int i=0; i<n; i++){
        if (arr[i] < mini)
            mini = arr[i];
    }
    return mini;
}


