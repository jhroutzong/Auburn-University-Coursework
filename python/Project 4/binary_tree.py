class BinaryTreeNode:
    def __init__(self, value, left_child=None, right_child=None):
        self.value = value
        self.parent = None
        self._left_child = left_child  # private
        self._right_child = right_child  # private
        if left_child:
            left_child.parent = self
        if right_child:
            right_child.parent = self

    @property
    def left_child(self):
        return self._left_child

    @property
    def right_child(self):
        return self._right_child


class BinaryTree:
    def __init__(self, root=None):
        self.root = root

    @property
    def root(self):
        return self._root

    @root.setter
    def root(self, r):
        self._root = r

    def __iter__(self):
        return InOrderIterator.iterator(self.root)


class PreOrderIterator:
    def __init__(self, node):
        self.a = []
        self.iterator(node)
        self.index = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.index >= len(self.a):
            raise StopIteration
        bc = self.a[self.index]
        self.index = self.index + 1
        return bc

    def iterator(self, node):
        if (node == None):
            return
        self.a.append(node.value)
        self.iterator(node.left_child)
        self.iterator(node.right_child)


class InOrderIterator:
    def __init__(self, node):
        self.a = []
        self.iterator(node)
        self.index = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.index >= len(self.a):
            raise StopIteration
        bc = self.a[self.index]
        self.index = self.index + 1
        return bc

    def iterator(self, node):   #  next should return next node
        if (node == None):
            return
        self.iterator(node.left_child)
        self.a.append(node.value)
        self.iterator(node.right_child)


class PostOrderIterator:
    def __init__(self, node):
        self.a = []
        self.iterator(node)
        self.index = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.index >= len(self.a):
            raise StopIteration
        bc = self.a[self.index]
        self.index = self.index + 1
        return bc

    def iterator(self, node):
        if (node == None):
            return
        self.iterator(node.left_child)
        self.iterator(node.right_child)
        self.a.append(node.value)


if __name__ == '__main__':
    a = ['a', 'b', 'c']
    print()
