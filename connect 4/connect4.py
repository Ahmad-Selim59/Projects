import numpy as np
import pygame
import sys
import math

ROW_COUNT = 6
COL_COUNT = 7
BLUE = (0, 0, 255)
BLACK = (0, 0, 0)
RED = (255, 0 ,0)
YELLOW = (255, 255, 0)


def create_board():
    board = np.zeros((ROW_COUNT,COL_COUNT))
    return board

def place_piece(board, row, col, piece):
    board[row][col] = piece

def place_valid(board, col):
    return board[ROW_COUNT-1][col] == 0

def get_next_open_row(board, col):
    for i in range(ROW_COUNT):
        if board[i][col] == 0:
            return i
    
def output_board(board):
    print(np.flip(board, 0))

def winning_move(board, piece):
    #horizontal
    for i in range (COL_COUNT-3):
        for n in range (ROW_COUNT):
            if board[n][i] == piece and board[n][i+1] == piece and board[n][i+2] == piece and board[n][i+3] == piece:
                return True
    
    #vertical

    for i in range(COL_COUNT):
        for n in range(ROW_COUNT-3):
            if board[n][i] == piece and board[n+1][i] == piece and board[n+2][i] == piece and board[n+3][i] == piece:
                return True

    #positive diagonals
    for i in range(COL_COUNT-3):
        for n in range(ROW_COUNT-3):
            if board[n][i] == piece and board[n+1][i+1] == piece and board[n+2][i+2] == piece and board[n+3][i+3] == piece:
                return True


    #negative diagonals
    for i in range(COL_COUNT-3):
        for n in range(3, ROW_COUNT):
            if board[n][i] == piece and board[n-1][i+1] == piece and board[n-2][i+2] == piece and board[n-3][i+3] == piece:
                return True
    
def draw_board(board):
    for i in range(COL_COUNT):
        for n in range(ROW_COUNT):
            pygame.draw.rect(screen, BLUE, (i*SQUARESIZE, n*SQUARESIZE+SQUARESIZE, SQUARESIZE, SQUARESIZE)) 
            pygame.draw.circle(screen, BLACK, (int(i*SQUARESIZE + SQUARESIZE/2), int(n*SQUARESIZE+SQUARESIZE+SQUARESIZE/2)), RADIUS)
            
    for i in range(COL_COUNT):
        for n in range(ROW_COUNT):
            if board[n][i] == 1:
                pygame.draw.circle(screen, RED, (int(i*SQUARESIZE + SQUARESIZE/2), height - int(n*SQUARESIZE+SQUARESIZE/2)), RADIUS)
            elif board[n][i] == 2:
                pygame.draw.circle(screen, YELLOW, (int(i*SQUARESIZE + SQUARESIZE/2), height - int(n*SQUARESIZE+SQUARESIZE/2)), RADIUS)
        pygame.display.update()





board = create_board()
output_board(board)
game_done = False
turn = 0

pygame.init()
SQUARESIZE = 100
width = COL_COUNT * SQUARESIZE
height = (ROW_COUNT+1) * SQUARESIZE
size = (width, height)
RADIUS = int(SQUARESIZE/2 - 5)

screen = pygame.display.set_mode(size)
draw_board(board)
pygame.display.update()

myfont = pygame.font.SysFont("monospace", 75)

while not game_done:
    
    for event in pygame.event.get():
        if event.type == pygame.MOUSEMOTION:
            pygame.draw.rect(screen, BLACK, (0,0, width, SQUARESIZE))
            posx = event.pos[0]
            if turn == 0:
                pygame.draw.circle(screen, RED, (posx, int(SQUARESIZE/2)), RADIUS)
            else:
                pygame.draw.circle(screen, YELLOW, (posx, int(SQUARESIZE/2)), RADIUS)
        pygame.display.update()

        if event.type == pygame.QUIT:
            sys.exit()
        
        if event.type == pygame.MOUSEBUTTONDOWN:
            #take input
            if turn == 0:
                posx = event.pos[0]
                col = int(math.floor(posx/SQUARESIZE))

                if place_valid(board, col):
                    row = get_next_open_row(board, col)
                    place_piece(board, row, col, 1)

                    if winning_move(board, 1):
                        label = myfont.render("Player 1 wins", 1, 2, RED)
                        screen.blit(label, (40,10))
                        game_done = True
            
            else:
                posx = event.pos[0]
                col = int(math.floor(posx/SQUARESIZE))

                if place_valid(board, col):
                    row = get_next_open_row(board, col)
                    place_piece(board, row, col, 2)
                    if winning_move(board, 2):
                        label = myfont.render("Player 2 wins", 1, 2, YELLOW)
                        screen.blit(label, (40,10))
                        game_done = True


            output_board(board)
            draw_board(board)
            
            turn += 1
            turn = turn % 2

            if game_done:
                pygame.time.wait(3000)




