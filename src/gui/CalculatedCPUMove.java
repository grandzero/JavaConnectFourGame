/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author BayramUtku
 */
/*
    This class has been developed as a modular to calculate computer movements.
    Takes board,moveCounter and board size and calculates best move
*/
public class CalculatedCPUMove {
    
    
    private int[] moveList;
    private int[][] gameBoard;
    private int i=-1;
    private int random;
    private int index;
    private int size;
    public CalculatedCPUMove(){
        /*Intentionally leaved blank*/
    }
    public CalculatedCPUMove(int[][] other,int mCounter,int Bsize){
        gameBoard = new int[Bsize][Bsize];
        for(int k=0;k<Bsize;++k){
            for(int s = 0; s<Bsize; ++s){
                gameBoard[k][s]=other[k][s];
            }
        }
        random = mCounter;
        size = Bsize;
        moveList = new int[2];
    }
    public int returnIndex(){
        
        //This code prevents player end the game
        for(int m=0;m<size;++m){
            simulateAdd(m);
            if(isFinished()){
                
                return m;
            }
            remove();
        }
        //this code looks if cpu can win
        for(int m = 0;m<size;++m){
            add(m);
            if(isFinished())
                return m;
            remove();
        }
        
        index = (random+1)%size;
        return index;
    }
    private void add(int col){
        /*This function takes a column and adds it to the gameboard*/
        for(int y=0;y<size;++y){
            if(gameBoard[col][y]!=0){
                gameBoard[col][y-1] = 2;
                y=size+1;
            }
        }
        ++i;
        moveList[i]=col;
        
          
    }
    private void simulateAdd(int col){
        /*This function takes a column and adds it to the gameboard as user*/
        for(int i = 0;i<size;++i){
            if(gameBoard[col][i]!=0){
                gameBoard[col][i-1] = 1;
                i=size+1;
            }
        }
        ++i;
        moveList[i]=col;
        
          
    }
    private void remove(){
        /*This function removes last move*/
        int col = moveList[i];
        
        for(int j = 0;j<size;++j){
            if(gameBoard[col][j]!=0){
                gameBoard[col][j-1] = 0;
                j=size+1;
            }
        }
        
        moveList[i]=-1;
        --i;
    
    }
   private boolean isFinished(){
       //Check for if game finished
    for(int i=0;i<size;++i){
        for(int j=0;j<size-3;++j){
            if(gameBoard[j][i]==1&&gameBoard[j+1][i]==1&&
               gameBoard[j+2][i]==1&&gameBoard[j+3][i]==1){
                    //cout<<"PLAYER 1 WON"<<endl;
                   
                    return true;
                    }
            else if(gameBoard[j][i]==2&&gameBoard[j+1][i]==2&&
                    gameBoard[j+2][i]==2&&gameBoard[j+3][i]==2){
                    //cout<<"PLAYER 2 WON"<<endl;
                   
                    return true;
                    }
        }
    }

for(int i=0;i<size;++i){
        for(int j=0;j<size-3;++j){
            if(gameBoard[i][j]==1&&gameBoard[i][j+1]==1&&
               gameBoard[i][j+2]==1&&gameBoard[i][j+3]==1){
                   // cout<<"PLAYER 1 WON"<<endl;
                   
                    return true;
                    }
            else if(gameBoard[i][j]==2&&gameBoard[i][j+1]==2&&
                    gameBoard[i][j+2]==2&&gameBoard[i][j+3]==2){
                    //cout<<"PLAYER 2 WON"<<endl;
                    
                    return true;
                    }
        }
    }

for(int i=0;i<size-3;++i){
        for(int j=0;j<size-3;++j){
            if(gameBoard[i][j]==1&&gameBoard[i+1][j+1]==1
                &&gameBoard[i+2][j+2]==1&&gameBoard[i+3][j+3]==1){
                    //cout<<"PLAYER 1 WON"<<endl;
                   
                    return true;
                    }
            else if(gameBoard[i][j]==2&&gameBoard[i+1][j+1]==2
                    &&gameBoard[i+2][j+2]==2&&gameBoard[i+3][j+3]==2){
                        //cout<<"PLAYER 2 WON"<<endl;
                        
                        return true;
                        }
            }
        }

    for(int i=0;i<size-3;++i){
        for(int j=3;j<size;++j){
            if(gameBoard[i][j]==1&&gameBoard[i+1][j-1]==1
                &&gameBoard[i+2][j-2]==1&&gameBoard[i+3][j-3]==1){
                    //cout<<"PLAYER 1 WON"<<endl;
                    
                    return true;
                    }
            else if(gameBoard[i][j]==2&&gameBoard[i+1][j-1]==2
                    &&gameBoard[i+2][j-2]==2&&gameBoard[i+3][j-3]==2){
                        //cout<<"PLAYER 2 WON"<<endl;
                        
                        return true;
                        }
            }
        }

    return false;

    }
}
