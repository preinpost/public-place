use std::io::{self, BufRead};

#[derive(Debug)]
struct BTree {
    left: Option<Box<BTree>>,
    right: Option<Box<BTree>>,
    val: i32,

}

impl BTree {
    fn new(val: i32) -> BTree {
        BTree {
            left: None,
            right: None,
            val,
        }
    }

    pub fn insert(&mut self, insert_value: i32) {
        if self.val > insert_value {
            match &mut self.left {
                Some(x) => x.insert(insert_value),
                None => self.left = Some(Box::new(BTree::new(insert_value))),
            }
        }

        if self.val < insert_value {
            match &mut self.right {
                Some(x) => x.insert(insert_value),
                None => self.right = Some(Box::new(BTree::new(insert_value)))
            }
        }
    }

    pub fn is_exist(&self, search_value: i32) -> bool {
        if self.val == search_value {
            return true;
        }

        if self.left.is_none() && self.right.is_none() {
            return false;
        }

        if search_value < self.val {
            return match &self.left {
                Some(x) => x.is_exist(search_value),
                None => false,
            }
        }

        if search_value > self.val {
            return match &self.right {
                Some(x) => x.is_exist(search_value),
                None => false,
            }
        }


        return false;

    }

}


#[cfg(test)]
mod tests {

    use super::*;

    #[test]
    fn test() {
        let mut root = BTree::new(12);
        root.insert(3);
        root.insert(15);

        dbg!(&root);
        
        let result = root.is_exist(4);
        dbg!(result);
        


    }
}

pub fn run() {
    let mut lines = io::stdin().lock().lines();
    
    let n = lines.next().unwrap().unwrap().parse::<i32>().unwrap();
    let n_list: Vec<_> = lines.next().unwrap().unwrap().split_ascii_whitespace().map(|s| s.parse::<i32>().unwrap()).collect();
    let m = lines.next().unwrap().unwrap().parse::<i32>().unwrap();
    let m_list: Vec<_> = lines.next().unwrap().unwrap().split_ascii_whitespace().map(|s| s.parse::<i32>().unwrap()).collect();

    let mut tree = BTree::new(n_list[0]);

    for (idx, number) in n_list.into_iter().enumerate() {
        if idx == 0 {
            continue;
        }

        tree.insert(number);
    }

    for num in m_list {
        if tree.is_exist(num) {
            println!("1");
        } else {
            println!("0");
        }
    }
}