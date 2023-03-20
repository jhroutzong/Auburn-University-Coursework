from curling_league_manager import *
import unittest



class LeagueDataBaseTests(unittest.TestCase):
    def test_add_league(self):
        b = LeagueDatabase()
        a = League(5, "The Competitors")
        b.add_league(a)
        self.assertIn(a, b.leagues)  # add assertion here


    def test_remove_league(self):
        b = LeagueDatabase()
        a = League(5, "The Competitors")
        b.add_league(a)
        b.remove_league(a)
        self.assertNotIn(a, b.leagues)

    def test_league_named(self):
        b = LeagueDatabase()
        a = League(5, "The Competitors")
        b.add_league(a)
        self.assertTrue(b.league_named("The Competitors"))

    def test_export_league_teams(self):
        b = LeagueDatabase()
        a = League(5, "The Competitors")
        c = Team(7, "The Curlers")
        d = TeamMember(11, "Jacob", "jzr0093@auburn.edu")
        c.add_member(d)
        a.add_team(c)
        b.add_league(a)
        b.export_league_teams(a, "test_export_league_teams")

    def test_import_league_teams(self):  # needs work
        b = LeagueDatabase()
        my_league = League(7, "My League")
        b.add_league(my_league)
        b.import_league_teams(my_league, "test_export_league_teams")
        print(b.leagues)

    def test_save(self):   # needs work
        b = LeagueDatabase()
        a = League(5, "The Competitors")
        c = Team(7, "The Curlers")
        d = TeamMember(11, "Jacob", "jzr0093@auburn.edu")
        c.add_member(d)
        a.add_team(c)
        b.add_league(a)
        b.save("test_file_for_saving")

    def test_load(self):
        b = LeagueDatabase()
        b.load("test_file_for_saving")
        a = []
        for league in b._sole_instance:
            a.append(league.name)
            print(league)
        self.assertIn("The Competitors", a)





if __name__ == '__main__':
    unittest.main()
