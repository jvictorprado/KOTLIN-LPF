fun main(args: Array<String>) {
  println(raizes({x->x*x-81},9,9))
}

fun raizes(f:(Int)->Int,x:Int,y:Int):Int{
  //maior - menor + 1 = tamanho do array 
  // diz oq entra no array em cada posição, o i vai ser um iterator (0,1,2... até o tamanho do array).. o retorno dessa função vai ser o numero que vai retornar na posição i do array
  // recebe o tam e a função que define os valores do array 
  val arr = IntArray((maior(x,y)-menor(x,y))+1,{i -> menor(x,y)+i});
  return solucao(f,arr)
}

fun maior(x:Int,y:Int): Int{
  if(x>y){
    return x
  }else{
    return y
  }
}

fun menor(x:Int,y:Int): Int{
  if(x>y){
    return y
  }else{
    return x
  }
}


fun solucao(f:(Int)->Int,arr: IntArray,n:Int=0,n2:Int=0):Int{
  if(n==arr.size){
    return n2
  }else if(f(arr[n])==0){
    return solucao(f,arr,n+1,n2+1)
  }else{
    return solucao(f,arr,n+1,n2)
  }
}







data class Node(val info: Int, val left: Node?, val right: Node?)

fun compare(a:Int, b:Int) = if(a>b) a else b

fun isBst(root: Node?): Boolean {
    if(root != null) {
        if(root.left != null && root.left.info > root.info)
            return false;
        
        if(root.right != null && root.right.info < root.info)
            return false
        
        if(!isBst(root.left) || !isBst(root.right))
            return false
    }
    
     return true
}

fun main() {
    val tree: Node = Node(10, Node(4, Node(3, Node(2, null, null), null), Node(6, Node(5, null, null), null)), Node(15, Node(11, null, null), Node(16, null, null)))
     
     println(isBst(tree))
}
