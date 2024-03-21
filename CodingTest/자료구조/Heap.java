package 자료구조;

import java.util.*;

public class Heap {
  
  //힙의 엘리먼트를 담는 변수
  public List<Integer> elems;

  public Heap(){
    //클래스 생성 시 빈리스트를 선언하고, 첫 번째 값을 널을 삽입하여 사용하지 않음
    elems = new ArrayList<>();
    elems.add(null);
  }
  public void swap(int i, int j){
    int temp = elems.get(i);
    elems.set(i, elems.get(j));
    elems.set(j,temp);
  }
  //삽입
  public void percolateUp(){
    //가장 끝에 있는 값
    int idx = elems.size()-1;
    //부모 인덱스
    int parentIdx = idx/2;

    while(parentIdx > 0){
        //부모 노드가 더 크면 값 스왑
        if(elems.get(idx) < elems.get(parentIdx)){
          int tmp = elems.get(idx);
          elems.set(idx, elems.get(parentIdx));
          elems.set(parentIdx, tmp);
        }

        idx = parentIdx;
        parentIdx = idx/2;
    }
  }

  public void insert(int val){
    elems.add(val);
    percolateUp();
  }
  
//다운힙
public void minHeapify(int i){
  //왼쪽 자식 노드 인덱스
  int left = i*2;
  //오른쪽 자식 노드 인덱스
  int right = i*2+1;
  //현재 노드의 값을 가장 작은 값으로 가정
  int smalles = i;

  //왼쪽 자식 노드가 존재하고 현재 노드의 값보다 더 작다면 가장 작은 값은 왼쪽 자식 노드로 선언
  if(left <= elems.size() -1 && elems.get(left) < elems.get(smalles)){
    smalles = left;
  }
  //오른쪽 자식 노드가 존재하고 현재 노드의 값보다 더 작다면 가장 적은 값은 오른쪽 자식 노드로 선언
  if(right <= elems.size()-1 && elems.get(right) < elems.get(smalles)){
    smalles = right;
  }
  if(smalles != i){
    swap(smalles, i);
    minHeapify(smalles);
  }
}
//최소힙 추출
public int extract(){
  int extracted = elems.get(1);

  elems.set(1, elems.get(elems.size()-1));

  elems.remove(elems.size()- 1);
  minHeapify(1);

  return extracted;
}

}
