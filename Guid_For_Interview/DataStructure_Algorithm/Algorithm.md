https://www.youtube.com/watch?v=axa2g5oOzCE
##Red Black Tree
    1. rule:
        1. root is black 
        2. leaf is black 
        3. if a node is red, then both its children are black
        4. for each node, all simple paths from the node to descendant leaves contain the same number of black nodes.
        5. new node is red 
        6. null node is black
    2. violations:
        1. case 1:  uncle node is red  --> **change color** of grandparent, parent, uncle  -->Grandparent becomes the new node to check for violations
        2. case 2: uncle node is black, violating node is a left child of a right child
                                                    or is a right child of a left child 
            --> rotate the violating node with its parent --> the parent becomes child, the violating child node becomes a parent 
            --> Parent becomes the new node to check for violations
            
        3. case 3:  uncle node is black, violating node is a left child of a left child
                                                    or is a right child of a right child
            -->  rotate the violating node with its parent --> the parent becomes child, the violating child node becomes a parent 
            --> **Swap colors** of Parent and Grandparent --> Grandparent becomes the new node to check for violation
    