"""This module is intended to do several seperate features using list comprehensions.

Features included:
#1 return a list of all evens from a list of integers
#2 return all numbers from a list that are a multiple of the parameter n (an integer)
#3 returns a tuple that is a max of each tuple element (1st, 2nd) from a list of tuples.
#4 returns a string converted to all lowercase.
#5 returns a list of all possible baby names, given "possible" names and a last name in the
    form (["name1", "name2"], "lastname")

"""

import math


def all_even(lst):
    """#1: returns a list of all evens from a list of integers"""
    return [x for x in lst if (x % 2 == 0)]


def all_not_multiple(lst, n):
    """#2: return all numbers from a list that are a multiple of the parameter n (an integer)"""
    return [x for x in lst if (x % n != 0)]


def max_from_2_tuples(tuples):
    """#3 returns a tuple that is a max of each tuple element (1st, 2nd) from a list of tuples."""
    if not tuples:
        return
    else:
        length = len(tuples)
        x = 1
        y = tuples[0][0]
        z = tuples[0][1]
        while x < length:
            if tuples[x][0] > y:
                y = tuples[x][0]
            if tuples[x][1] > z:
                z = tuples[x][1]
            x = x + 1
        return (y, z)



def lower_case_words(sentence):
    """#4 returns a list of words converted to all lowercase from a string."""
    a = sentence.split()
    if a == "":
        return []
    else:
        return [x.lower() for x in a]


def baby_names(names, last_name):
    """#5 returns a list of all possible baby names, given "possible" names and a last name in the
    form (["name1", "name2"], "lastname")"""
    x = 0
    y = len(names)
    names_list = []
    while x < y:
        z = 0
        while z < y:
            if names[x] != names[z]:
                string_a = names[x] + " " + names[z] + " " + last_name
                names_list.append(string_a)
            z = z + 1
        x = x + 1
    return names_list


if __name__ == "__main__":
    main()