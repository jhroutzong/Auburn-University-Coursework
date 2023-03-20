"""This module is intended to simulate a game of Tic Tac Toe.
    In order to run, simply follow the instructions in
    the command prompt."""
import random

turn_count = 0
current_player = 0
board = [[" ", " ", " "],
         [" ", " ", " "],
         [" ", " ", " "]]


def initializes_game():
    global current_player
    current_player = random.randint(1, 2)
    # z = 0
    # while z < 3:
    #     board[z][0] = 0
    #     board[z][1] = 0
    #     board[z][2] = 0


def player_switch():
    global current_player
    if current_player == 1:
        current_player = 2
    else:
        current_player = 1





def print_board():
    print(board[0][0] + " | " + board[0][1] + " | " + board[0][2])
    print("--+---+--")
    print(str(board[1][0]) + " | " + str(board[1][1]) + " | " + str(board[1][2]))
    print("--+---+--")
    print(str(board[2][0]) + " | " + str(board[2][1]) + " | " + str(board[2][2]))
    if turn_count == 9:
        end_game()



def prints_and_takes_turn():
    global current_player
    global board
    global turn_count
    print("Player " + str(current_player) + " choose your selection in the format \"RowColumn\" (0-2), with no spaces")
    print("(Rows are horizontal, Columns are vertical.)")
    print_board()
    a = tuple(input())
    b = int(a[0])
    c = int(a[2])
    if str(board[b][c]) == " " and current_player == 1:
        board[b][c] = "X"
        turn_count = turn_count + 1
        player_switch()
        checks_for_victory()
    elif str(board[b][c]) == " " and current_player == 2:
        board[b][c] = "O"
        turn_count = turn_count + 1
        player_switch()
        checks_for_victory()
    else:
        print("Incorrect move. Try again.")
        prints_and_takes_turn()


def end_game():
    global current_player
    global turn_count

    # if turn_count == 9:
    #
    #     print("The game ended in a draw. Would you like to play again? \"Yes\" or \"No\"")
    #     a = str.lower(input())
    #     if a == "yes":
    #         main()
    #     else:
    #         print("Thanks for playing.")
    print_board()
    player_switch()
    print("The game is over. Player " + str(current_player) + " claims victory.")
    print("Would you like to play again? \"Yes\" or \"No\"")
    play_again = str.lower(input())
    if play_again == "yes":
        main()
    else:
        print("Thanks for playing.")


def checks_for_victory():
    global current_player
    global board
    if board[0][0] == "X" and board[0][1] == "X" and board[0][2] == "X":
        end_game()
    elif board[0][0] == "X" and board[1][0] == "X" and board[2][0] == "X":
        end_game()
    elif board[0][2] == "X" and board[1][2] == "X" and board[2][2] == "X":
        end_game()
    elif board[2][0] == "X" and board[2][1] == "X" and board[2][2] == "X":
        end_game()
    elif board[0][2] == "X" and board[1][1] == "X" and board[2][0] == "X":
        end_game()
    elif board[0][0] == "X" and board[1][1] == "X" and board[2][2] == "X":
        end_game()
    elif board[1][0] == "X" and board[1][1] == "X" and board[1][2] == "X":
        end_game()
    elif board[2][0] == "X" and board[2][1] == "X" and board[2][2] == "X":
        end_game()
        #
    elif board[0][0] == "O" and board[0][1] == "O" and board[0][2] == "O":
        end_game()
    elif board[0][0] == "O" and board[1][0] == "O" and board[2][0] == "O":
        end_game()
    elif board[0][2] == "O" and board[1][2] == "O" and board[2][2] == "O":
        end_game()
    elif board[2][0] == "O" and board[2][1] == "O" and board[2][2] == "O":
        end_game()
    elif board[0][2] == "O" and board[1][1] == "O" and board[2][0] == "O":
        end_game()
    elif board[0][0] == "O" and board[1][1] == "O" and board[2][2] == "O":
        end_game()
    elif board[1][0] == "O" and board[1][1] == "O" and board[1][2] == "O":
        end_game()
    elif board[2][0] == "O" and board[2][1] == "O" and board[2][2] == "O":
        end_game()
    elif turn_count == 9:
        print("The game ended in a draw. Would you like to play again? \"Yes\" or \"No\"")
        a = str.lower(input())
        if a == "yes":
            main()
        else:
            print("Thanks for playing.")
    else:
        prints_and_takes_turn()


def main():
    initializes_game()
    prints_and_takes_turn()


if __name__ == "__main__":
    main()
