int maximum(int *arr, int n){
    int maxi = arr[0];
    for (int i=0; i<n; i++){
        if (arr[i] > maxi)
            maxi = arr[i];
    }
    return maxi;
}


