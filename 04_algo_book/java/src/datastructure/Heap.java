package datastructure;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {

    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data) {
        heapArray = new ArrayList<Integer>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean move_up(Integer inserted_index) {
        // 여기서는 swap 해야하는지 판단만

        if (inserted_index <= 1) {
            return false;
        }

        Integer parent_index = inserted_index / 2;
        if (this.heapArray.get(inserted_index) > this.heapArray.get(parent_index)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean insert(Integer data) {
        Integer inserted_index, parent_idex;

        if (heapArray == null) {
            heapArray = new ArrayList<>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        inserted_index = this.heapArray.size() - 1;

        while (this.move_up(inserted_index)) {
            parent_idex = inserted_index / 2;
            Collections.swap(this.heapArray, inserted_index, parent_idex);
            inserted_index = parent_idex;
        }
        return true;
    }

    public Integer pop() {
        Integer returned_data, popped_index, left_child_popped_index, right_child_popped_index;

        if (this.heapArray == null) {
            return null;
        } else {
            returned_data = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);

            popped_index = 1;

            while (this.move_down(popped_index)) {
                left_child_popped_index = popped_index * 2;
                right_child_popped_index = popped_index * 2 + 1;

                if (right_child_popped_index >= this.heapArray.size()) {
                // CASE2: 오른쪽 자식 노드만 없을 때
                    if (this.heapArray.get(popped_index) < this.heapArray.get(left_child_popped_index)) {
                        Collections.swap(heapArray, popped_index, left_child_popped_index);
                        popped_index = left_child_popped_index;
                    }
                } else {
                // CASE3: 왼쪽/오른쪽 자식 노드가 모두 있을 때
                    if (this.heapArray.get(left_child_popped_index) > this.heapArray.get(right_child_popped_index)) {
                        if (this.heapArray.get(popped_index) < this.heapArray.get(left_child_popped_index)) {
                            Collections.swap(heapArray, popped_index, left_child_popped_index);
                            popped_index = left_child_popped_index;
                        }
                    } else {
                        if (this.heapArray.get(popped_index) < this.heapArray.get(right_child_popped_index)) {
                            Collections.swap(heapArray, popped_index, right_child_popped_index);
                            popped_index = right_child_popped_index;
                        }
                    }
                }

            }
            return returned_data;
        }

    }

    public boolean move_down(Integer popped_index) {
        Integer left_child_popped_index, right_child_popped_index;

        left_child_popped_index = popped_index * 2;
        right_child_popped_index = popped_index * 2 + 1;

        if (left_child_popped_index >= this.heapArray.size()) {
        // CASE1: 왼쪽 자식 노드도 없을 때 (자식 노드가 하나도 없을 때)
            return false;
        } else if (right_child_popped_index >= this.heapArray.size()) {
        // CASE2: 오른쪽 자식 노드만 없을 때
            if (this.heapArray.get(popped_index) < this.heapArray.get(left_child_popped_index)) {
                return true;
            } else {
                return false;
            }
        } else {
        // CASE3: 왼쪽/오른쪽 자식 노드가 모두 있을 때
            if (this.heapArray.get(left_child_popped_index) > this.heapArray.get(right_child_popped_index)) {
                if (this.heapArray.get(popped_index) < this.heapArray.get(left_child_popped_index)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.heapArray.get(popped_index) < this.heapArray.get(right_child_popped_index)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(15);

        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        heap.insert(20);

        System.out.println("heap = " + heap.heapArray);

        heap.pop();

        System.out.println("heap = " + heap.heapArray);

    }


}
