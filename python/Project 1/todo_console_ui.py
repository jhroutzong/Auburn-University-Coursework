from datetime import datetime
z = 1
num_of_items = 0
my_list = []
while z:
    print("\nMain menu:")
    print("1) List ALL todo items")
    print("2) List all incomplete todo items")
    print("3) List incomplete todo items due today")
    print("4) Add a todo item")
    print("5) Complete a todo item")
    print("6) Quit")
    print("Enter your choice ")
    choice = input()
    if choice == "1":
        print("All items: \n")
        for x in range(len(my_list)):
            str_datetime = my_list[x][1].strftime("%Y-%d-%m %H:%M:%S")
            print("\t\t", my_list[x][0], str_datetime)
    elif choice == "2":
        print("Incomplete items: \n")
        for x in range(len(my_list)):
            if my_list[x][2] == "Incomplete":
                str_datetime = my_list[x][1].strftime("%Y-%d-%m %H:%M:%S")
                print("\t\t", my_list[x][0], str_datetime, my_list[x][2])
    elif choice == "3":
        print("Incomplete items due today: \n")
        for x in range(len(my_list)):
            if my_list[x][2] == "Incomplete":
                todays_date = datetime.today().strftime('%Y-%d-%m')
                todays_date_from_source = my_list[x][1].strftime('%Y-%d-%m')
                str_datetime = my_list[x][1].strftime("%Y-%d-%m %H:%M:%S")
                if todays_date == todays_date_from_source:
                    print(my_list[x][0], str_datetime)
    elif choice == "4":
        a = input("Enter item description: ")
        bb = input("Enter due date/time (MM/DD/YYYY hh:mm): ")
        b = datetime.strptime(bb, '%m/%d/%Y %H:%M')
        print(b)
        c = "Incomplete"
        user_input = a, b, c
        my_list.insert(num_of_items, user_input)
        num_of_items += 1
    elif choice == "5":
        print("Incomplete items: \n")
        choice_num = 1
        for x in range(len(my_list)):
            if my_list[x][2] == "Incomplete":
                str_datetime = my_list[x][1].strftime("%Y-%d-%m %H:%M:%S")
                print(choice_num, ")", my_list[x][0], str_datetime)
                choice_num += 1
        print("Enter your choice")
        completion_choice = input()
        completion_choice = int(completion_choice)
        match_num = 0
        for x in range(len(my_list)):
            if my_list[x][2] == "Incomplete":
                match_num += 1
                if match_num == completion_choice:
                    a = my_list[x][0]
                    b = my_list[x][1]
                    c = "Complete"
                    del my_list[x]
                    my_list.insert(x, (a, b, c))
                    break
                else:
                    match_num += 1
    elif choice == "6":
        z = 0





