public class BacktrackingArray implements Array<Integer>, Backtrack {
    private Stack stack;
    private int[] arr;
    private int size; //holds how many elements have been inserted to the array\the next available index

    // Do not change the constructor's signature
    public BacktrackingArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
        this.size=0;
    }

    @Override
    public Integer get(int index){
        if (index < 0 | index >= size)
            return null;
        return arr[index];
    }

    @Override
    public Integer search(int x) {
        for (int i=0;i<arr.length;i=i+1) {
            if (arr[i]==x)
                return i;
        }
        return -1;
    }

    @Override
    public void insert(Integer x) {
        if (size==arr.length)
            throw new RuntimeException("no room left in the array");
        arr[size]=x;
        size=size+1;
        stack.push('i');
    }

    @Override
    public void delete(Integer index) {
        if (index>=0 & index<size) {
            stack.push(arr[index]);
            if (size > 0) {
                if (size == 1)
                    size = 0;
                else {
                    arr[index] = arr[size - 1];
                    size = size - 1;
                }
                stack.push(index);
                stack.push('d');
            }
        }
    }

    @Override
    public Integer minimum() {
        if (size==0)
            return -1;
        Integer output=0;
        for (int i=1;i<size;i=i+1) {
            if (arr[i]<arr[output])
                output=i;
        }
        return output;
    }

    @Override
    public Integer maximum() {
        if (size==0)
            return -1;
        Integer output=0;
        for (int i=1;i<size;i=i+1) {
            if (arr[i]>arr[output])
                output=i;
        }
        return output;
    }

    @Override
    public Integer successor(Integer index) {
        if (index<0 | index>=size)
            throw new IndexOutOfBoundsException("index is out of bounds");
        Integer output=-1;
        for (int i=0;i<index;i=i+1) {
            if (arr[i]>arr[index] && (output==-1 || arr[output]>arr[i]))
                output=i;
        }
        for (int j=index+1;j<size;j=j+1) {
            if (arr[j]>arr[index] && (output==-1 || arr[output]>arr[j]))
                output=j;
        }
        return output;
    }

    @Override
    public Integer predecessor(Integer index) {
        if (index<0 | index>=size)
            throw new IndexOutOfBoundsException("index is out of bounds");
        Integer output=-1;
        for (int i=0;i<index;i=i+1) {
            if (arr[i]<arr[index] && (output==-1 || arr[output]<arr[i]))
                output=i;
        }
        for (int j=index+1;j<size;j=j+1) {
            if (arr[j]<arr[index] && (output==-1 || arr[output]<arr[j]))
                output=j;
        }
        return output;
    }

    @Override
    public void backtrack() {
        if (!stack.isEmpty()) {
            if (((char)stack.pop())=='i') {
                arr[size-1]=0;
                size = size - 1;
            }
            else {
                int delIndex=(int)stack.pop();
                int delVal=(int)stack.pop();
                arr[size]=arr[delIndex];
                arr[delIndex]=delVal;
                size=size+1;
            }
            System.out.println("backtracking performed");
        }
    }

    @Override
    public void retrack() {
        // Do not implement anything here!!
    }

    @Override
    public void print() {
        if (size>0) {
            for (int i = 0; i < size - 1; i = i + 1) {
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[size - 1]);
        }
    }
}
