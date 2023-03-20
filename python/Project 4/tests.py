import datetime
import unittest
from binary_tree import *
from iterators import *
from generators import *
from curling_league_manager import *


class BinaryTreeTests(unittest.TestCase):
    def test_in_order_traversal(self):
        tree = self.initialize_tree()
        b = InOrderIterator(tree.root)
        self.assertEqual("D", next(b))
        self.assertEqual("E", next(b))
        self.assertEqual("A", next(b))
        self.assertEqual("C", next(b))
        self.assertEqual("B", next(b))
        self.assertEqual("F", next(b))
        self.assertEqual("H", next(b))
        self.assertEqual("G", next(b))
        with self.assertRaises(StopIteration):
            next(b)

    def test_post_order_traversal(self):
        tree = self.initialize_tree()
        b = PostOrderIterator(tree.root)
        self.assertEqual("D", next(b))
        self.assertEqual("A", next(b))
        self.assertEqual("B", next(b))
        self.assertEqual("C", next(b))
        self.assertEqual("E", next(b))
        self.assertEqual("F", next(b))
        self.assertEqual("G", next(b))
        self.assertEqual("H", next(b))
        with self.assertRaises(StopIteration):
            next(b)

    def test_pre_order_traversal(self):
        tree = self.initialize_tree()
        b = PreOrderIterator(tree.root)
        self.assertEqual("H", next(b))
        self.assertEqual("F", next(b))
        self.assertEqual("E", next(b))
        self.assertEqual("D", next(b))
        self.assertEqual("C", next(b))
        self.assertEqual("A", next(b))
        self.assertEqual("B", next(b))
        self.assertEqual("G", next(b))
        with self.assertRaises(StopIteration):
            next(b)

    @staticmethod
    def initialize_tree():
        n1 = BinaryTreeNode("A")
        n2 = BinaryTreeNode("B")
        n3 = BinaryTreeNode("C", n1, n2)
        # two children, a & b
        n4 = BinaryTreeNode("D")
        n5 = BinaryTreeNode("E", n4, n3)
        # two children, c and d
        n6 = BinaryTreeNode("F", n5)
        # one left child, e
        n7 = BinaryTreeNode("G")
        n8 = BinaryTreeNode("H", n6, n7)
        # two children, f and g
        return BinaryTree(n8)


class IteratorsTests(unittest.TestCase):
    def test_for_odd_nums(self):
        a = []
        it = [1, 5, 7, 10, 15, 20]
        for i in OddIterator(it):
            a.append(i)
        self.assertEqual(a, [1, 5, 7, 15])

    def test_for_last_func(self):
        a = []
        b = []
        it = [1, 2, 3, 4, 5]
        for i in Last(it, 2):
            a.append(i)
        self.assertEqual(a, [4, 5])

        for i in Last(it, 7):
            b.append(i)
        self.assertEqual(b, [1, 2, 3, 4, 5])


class GeneratorTests(unittest.TestCase):
    def test_for_fibonacci(self):
        g = fibonacci()
        self.assertEqual(next(g), 1)
        self.assertEqual(next(g), 1)
        self.assertEqual(next(g), 2)
        self.assertEqual(next(g), 3)
        self.assertEqual(next(g), 5)
        self.assertEqual(next(g), 8)
        self.assertEqual(next(g), 13)


class LeagueTests(unittest.TestCase):
    def test_create(self):
        league = League(1, "AL State Curling League")
        self.assertEqual(1, league.oid)
        self.assertEqual("AL State Curling League", league.name)
        self.assertEqual([], league.teams)
        self.assertEqual([], league.competitions)

    def test_adding_team_adds_to_teams(self):
        t = Team(1, "Ice Maniacs")
        league = League(1, "AL State Curling League")
        self.assertNotIn(t, league.teams)
        league.add_team(t)
        self.assertIn(t, league.teams)

    def test_adding_competition_adds_to_competitions(self):
        c = Competition(1, [], "Local tourney", None)
        league = League(13, "AL State Curling League")
        self.assertNotIn(c, league.competitions)
        league.add_competition(c)
        self.assertIn(c, league.competitions)

    @staticmethod
    def build_league():
        league = League(1, "Some league")
        t1 = Team(1, "t1")
        t2 = Team(2, "t2")
        t3 = Team(3, "t3")
        all_teams = [t1, t2, t3]
        league.add_team(t1)
        league.add_team(t2)
        league.add_team(t3)
        tm1 = TeamMember(1, "Fred", "fred")
        tm2 = TeamMember(2, "Barney", "barney")
        tm3 = TeamMember(3, "Wilma", "wilma")
        tm4 = TeamMember(4, "Betty", "betty")
        tm5 = TeamMember(5, "Pebbles", "pebbles")
        tm6 = TeamMember(6, "Bamm-Bamm", "bam-bam")
        tm7 = TeamMember(7, "Dino", "dino")
        tm8 = TeamMember(8, "Mr. Slate", "mrslate")
        t1.add_member(
            tm1)  # I think I broke PyCharm here, I was trying to fix the test on line 86, and after reverting it throws some sort of error here
        t1.add_member(tm2)
        t2.add_member(tm3)
        t2.add_member(tm4)
        t2.add_member(tm5)
        t3.add_member(tm6)
        t3.add_member(tm7)
        t3.add_member(tm8)
        # every team plays every other team twice
        oid = 1
        for c in [Competition(oid := oid + 1, [team1, team2], team1.name + " vs " + team2.name, None)
                  for team1 in all_teams
                  for team2 in all_teams
                  if team1 != team2]:
            league.add_competition(c)
        return league

    def test_team_named(self):
        league = self.build_league()
        t = league.team_named("t1")
        print(league.teams[0])
        print(t)
        self.assertEqual(league.teams[0], t)
        t = league.team_named("t3")
        self.assertEqual(league.teams[2], t)
        t = league.team_named("bogus")
        self.assertIsNone(t)

    def test_big_league(self):
        league = self.build_league()
        t = league.teams[0]
        cs = league.competitions_for_team(t)
        # matchups are (t1, t2), (t1, t3), (t2, t1), (t3, t1) but we don't know what order they will be returned in
        # so use sets.
        cs_names = {c.location for c in cs}  # set comprehension # c.location
        self.assertEqual({"t1 vs t2", "t1 vs t3", "t2 vs t1", "t3 vs t1"}, cs_names)
        # print(league.teams[2])
        self.assertEqual([league.teams[2]], league.teams_for_member(league.teams[2].members[0]))

        # Grab a player from the third team
        cs = league.competitions_for_member(league.teams[2].members[0])
        # matchups are (t3, t1), (t3, t2), (t2, t3), (t1, t3) but we don't know what order they will be returned in
        # so use sets.
        cs_names = {c.location for c in cs}  # set comprehensions
        self.assertEqual({"t3 vs t1", "t3 vs t2", "t2 vs t3", "t1 vs t3"}, cs_names)

class FakeEmailer:
    def __init__(self):
        self.recipients = None
        self.subject = None
        self.message = None

    def send_plain_email(self, recipients, subject, message):
        self.recipients = recipients
        self.subject = subject
        self.message = message


class TeamMemberTests(unittest.TestCase):
    def test_create(self):
        oid = 1
        name = "Fred"
        email = "fred.flintstone@gmail.com"
        tm = TeamMember(oid, name, email)
        self.assertEqual(oid, tm.oid)
        self.assertEqual(name, tm.name)
        self.assertEqual(email, tm.email)

    def test_equality_based_on_id(self):
        tm_1 = TeamMember(1, "name", "email")
        tm_2 = TeamMember(1, "other name", "other email")
        tm_3 = TeamMember(2, "name", "email")

        # team members must be equal to themselves
        self.assertTrue(tm_1 == tm_1)
        self.assertTrue(tm_2 == tm_2)
        self.assertTrue(tm_3 == tm_3)

        # same id are equal, even if other fields different
        self.assertTrue(tm_1 == tm_2)

        # different ids are not equal, even if other fields the same
        self.assertTrue(tm_1 != tm_3)

    def test_hash_based_on_id(self):
        tm_1 = TeamMember(1, "name", "email")
        tm_2 = TeamMember(1, "other name", "other email")
        tm_3 = TeamMember(2, "name", "email")

        # hash depends only on id
        self.assertTrue(hash(tm_1) == hash(tm_2))

        # objects with different id's may have different hash codes
        # note: this is not a requirement of the hash function but
        # for the case of id == 1 and id == 2 we can verify that their
        # hash codes are different in a REPL (just print(hash(1)) etc).
        self.assertTrue(hash(tm_1) != hash(tm_3))

    def test_str(self):
        tm_1 = TeamMember(1, "name", "email")
        tm_2 = TeamMember(1, "other name", "other email")
        self.assertEqual("name<email>", str(tm_1))
        self.assertEqual("other name<other email>", str(tm_2))



    def test_sends_email(self):  # needs fixing
        tm_1 = TeamMember(1, "name", "email")
        tm_2 = TeamMember(1, "other name", "other email")
        fe = FakeEmailer()
        tm_1.send_email(fe, "Foo", "Bar")
        self.assertEqual(["email"], fe.recipients)
        self.assertEqual("Foo", fe.subject)
        self.assertEqual("Bar", fe.message)
        tm_2.send_email(fe, "Different", "Ugh")
        self.assertEqual(["other email"], fe.recipients)
        self.assertEqual("Different", fe.subject)
        self.assertEqual("Ugh", fe.message)


class CompetitionTests(unittest.TestCase):
    def test_create(self):
        now = datetime.datetime.now()
        t1 = Team(1, "Team 1")
        t2 = Team(2, "Team 2")
        t3 = Team(3, "Team 3")
        c1 = Competition(1, [t1, t2], "Here", None)
        c2 = Competition(2, [t2, t3], "There", now)

        self.assertEqual("Here", c1.location)
        self.assertEqual(1, c1.oid)
        self.assertIsNone(c1.date_time)
        self.assertEqual(2, len(c1.teams_competing))
        self.assertIn(t1, c1.teams_competing)
        self.assertIn(t2, c1.teams_competing)
        self.assertNotIn(t3, c1.teams_competing)

        self.assertEqual("There", c2.location)
        self.assertEqual(2, c2.oid)
        self.assertEqual(now, c2.date_time)
        self.assertEqual(2, len(c2.teams_competing))
        self.assertNotIn(t1, c2.teams_competing)
        self.assertIn(t2, c2.teams_competing)
        self.assertIn(t3, c2.teams_competing)

    def test_email(self):
        now = datetime.datetime.now()
        tm_1 = TeamMember(1, "name", "email1")
        tm_2 = TeamMember(2, "other name", "other email")
        tm_3 = TeamMember(3, "name", "email2")
        t1 = Team(1, "Team 1")
        t2 = Team(2, "Team 2")
        t1.add_member(tm_3)
        t2.add_member(tm_3)
        t1.add_member(tm_2)
        t2.add_member(tm_1)
        c1 = Competition(1, [t1, t2], "Here", None)

        fe = FakeEmailer()
        c1.send_email(fe, "Today's game", "Be there 3:30")
        self.assertEqual("Today's game", fe.subject)
        self.assertEqual("Be there 3:30", fe.message)
        self.assertIn("email1", fe.recipients)
        self.assertIn("other email", fe.recipients)
        self.assertIn("email2", fe.recipients)
        self.assertEqual(3, len(fe.recipients))

