class IdentifiedObject:
    """Instantiates the identifier variable to be incremented by one each time an object is created."""

    @property
    def oid(self):
        return self._oid

    def __init__(self, oid):
        self._oid = oid

    def __eq__(self, other):
        if self.__class__ is other.__class__ and self._oid == other.oid:
            return True
        else:
            return False

    def __hash__(self):
        return hash(self.oid)


class League(IdentifiedObject):

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value

    @property
    def teams(self):
        return self._teams  # a list

    @property
    def competitions(self):
        return self._competitions  # a list

    def __init__(self, oid, name):
        super().__init__(oid)
        self.name = name
        self._teams = []
        self._competitions = []

    def add_team(self, team):
        for x in self._teams:
            if x.oid == team.oid:
                raise DuplicateOid  # check for accuracy <------
        self._teams.append(team)

    def remove_team(self, team):
        for y in self._competitions:
            if team == y:
                raise ValueError  # <------ check for accuracy
        for x in self._teams:
            if x == team:
                self.teams.remove(x)  # <----- remove for loop?

    def team_named(self, s):
        for team in self._teams:
            if s == team.name:
                return team
            # else
            #     return None

    def add_competition(self, competition):
        for x in self._competitions:
            if x.oid == competition.oid:
                raise ValueError("The competition you are trying to add is already in the list.")
        self._competitions.append(competition)
                  # <----- check for accuracy


    def teams_for_member(self, member):
        teams_for_member0 = []
        for x in self._teams:
            for mem in x.members:
                if str(member) == str(mem):
                    teams_for_member0.append(x)
                # if y == member:

        return teams_for_member0

    def competitions_for_team(self, team):
        # return for x in self.competition if team in self.competition
        _local_competitions = []
        for x in self._competitions:
            if team in x.teams_competing:
                _local_competitions.append(x)

        return _local_competitions

    def competitions_for_member(self, member):
        all_competitions = []
        for competition in self._competitions:
            for team in competition.teams_competing:
                if member in team.members:
                    all_competitions.append(competition)
        return all_competitions

    def __str__(self):

        return self._name + ": " + str(self._teams.count) + " teams, " + str(self._competitions.count) + "competitions"


class Team(IdentifiedObject):  #

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value

    @property
    def members(self):
        return self._members  # a list

    def __init__(self, oid, name):
        super().__init__(oid)
        self._name = name
        self._members = []

    def add_member(self, member):
        for m in self._members:
            if member.oid == m.oid:
                raise DuplicateOid
            elif str(member.email).lower() == str(m.email).lower():
                raise DuplicateEmail
        self._members.append(member)  # <------- check for accuracy

    def member_named(self, s):
        for member in self._members:
            if member.name == s:
                return member
            else:
                return None

    def remove_member(self, member):
        if member in self._members:
            self._members.remove(member)

    def send_email(self, emailer, subject, message):   # <---- is this the correct way to do this?
        a = []
        for member in self._members:
            if member.email is not None:
                a.append(member.email)

        emailer.send_plain_email(a, subject, message)

        # use the emailer argument to send an email to all members of a team except those whose email address is None

    def __str__(self):
        return str(self._name + ": " + str(self._members.count) + " members")


class TeamMember(IdentifiedObject):

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value

    @property
    def email(self):
        return self._email

    @email.setter
    def email(self, value):
        self._email = value

    def __init__(self, oid, name, email):
        super().__init__(oid)
        self._name = name
        self._email = email

    def send_email(self, emailer, subject, message):
        if self._email is not None:
            emailer.send_plain_email([self._email], subject, message)
        # use the emailer argument to send an email to to this member

    def __str__(self):
        return self._name + "<" + self._email + ">"


class Competition(IdentifiedObject):

    @property
    def teams_competing(self):
        return self._teams

    @property
    def date_time(self):
        return self._datetime

    @date_time.setter
    def date_time(self, value):
        self._datetime = value

    @property
    def location(self):
        return self._location

    @location.setter
    def location(self, value):
        self._location = value

    def __init__(self, oid, teams, location, datetime):
        super().__init__(oid)
        self._teams = teams
        self._location = location
        self._datetime = datetime

    def send_email(self, emailer, subject, message):
        print('hello')
        a = set()
        for team in self._teams:
            for member in team.members:
                if member.email is not None:
                    a.add(member.email)
        emailer.send_plain_email(a, subject, message)  #  <---- check for correctness

    def __str__(self):
        return "Competition at " + self._location + "on " + self._datetime + "with " + self._teams.count + " teams"


class Emailer:
    _sender_address = ""
    _sole_instance = None

    @classmethod
    def configure(cls, sender_address):
        cls._sender_address = sender_address

    @classmethod
    def instance(cls):
        if cls._sole_instance is None:
            cls._sole_instance = cls()
        return cls._sole_instance

    def send_plain_email(self, recipients, subject, message):
        for recipient in recipients:
            print(f"Sending mail to: " + recipient)



class DuplicateOid(Exception):
    pass

    def __init__(self, oid):
        self._oid = oid
        # set in super? (Identified Object?)


class DuplicateEmail(Exception):
    pass

    def __init__(self, email):
        self._email = email
        # set in super? (Team Member?)


# 4) Modify League.remove_team(t) so that it ensures that the team being removed is not in any competitions.  If the
# team is in a competition, throw ValueError.


# Emailer -- a singleton
#
# class variable sender_address class variable _sole_instance -- the only instance of this class class method
# configure(sender_address) -- sets the class variable as specified class method instance() -- return the only
# instance of this class send_plain_email(recipients, subject, message) -- Note: this is an instance method.
# recipients must be a collection of email addresses (not TeamMembers!).  subject and message are strings.  Just have
# this method print f"Sending mail to: {recipient}" for each recipient in the recipients list.  We'll cover sending
# e-mail from Python later.

if __name__ == "__main__":
    print("hello")
