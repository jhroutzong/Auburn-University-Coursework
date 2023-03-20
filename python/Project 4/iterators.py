class OddIterator:
    def __init__(self, it):
        self.a = []
        self.index = 0
        self.it = it
        self.other_iterator = iter(it)
        self.ab = len(it)
        self.is_odd(it)



    def __iter__(self):
        return self

    def __next__(self):
        if self.index >= len(self.a):
            raise StopIteration
        bc = self.a[self.index]
        self.index = self.index + 1
        return bc

    def is_odd(self, it):
        while self.ab > 0:
            m = next(self.other_iterator)
            if m % 2 == 1:
                self.a.append(m)
            self.ab = self.ab - 1
        return self.a

class Last:
    def __init__(self, it, count):
        self.other_iterator = iter(it)
        self.count = count
        self.a = count
        self.it = it
        self.b = []
        self.index = 0
        self.calc_last(it, count)

    def __iter__(self):
        return self

    def __next__(self):
        if self.index >= len(self.b):
            raise StopIteration
        bc = self.b[self.index]
        self.index = self.index + 1
        return bc

    def calc_last(self, it, count):

        while self.a > 0:
            if self.count > len(self.it):
                self.b = list(it)
                return self.b
            else:
                var = (len(self.it) - self.a)
                self.b.append(it[var])
                self.a = self.a - 1
        return self.b
