package ticTacToeGame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.applet.Applet;
import javax.swing.JApplet;

public class TicTacToe2 extends JApplet implements ActionListener {
	
	JButton squares[];
	JButton newGameButton;
	Label score;
	int emptySquaresLeft = 9;
	
	// Метод init - это конструктор апплета
	
	public void init() {
	// устанавливаем менеджер расположения апплета, шрифт и цвет
		this.setLayout(new BorderLayout());
		this.setBackground(Color.CYAN);
		
		// изменяем шрифт апплета так, чтобы он был жирным и имел размер 20
		Font appletFont = new Font("Monospased", Font.BOLD, 20);
		this.setFont(appletFont);
		
		// создаем кнопку "New Game" и регистрируем в ней слушатель действия
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);
		JPanel topPanel = new JPanel();
		topPanel.add(newGameButton);
		
		this.add(topPanel, "North");
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 3));
		this.add(centerPanel, "Center");
		
		score = new Label("Your turn!");
		this.add(score, "South");
		
		// создаем массив, чтобы хранить ссылки на 9 кнопок
		squares = new JButton[9];
		
		// Создаем кнопки, сохраняем ссылки на них в массиве, регистируем в них слушатель, красим их в оранжевый цвет и добавляем на панель
		for(int i = 0; i < 9; i++) {
			squares[i] = new JButton();
			squares[i].addActionListener(this);
			squares[i].setBackground(Color.ORANGE);
		}
	}
	// Этот метод будет обрабатывать все события @param ActionEvent объект
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		JButton theButton = (JButton) e.getSource();
		
		// это кнопка New Game?
		if(theButton == newGameButton) {
			System.out.println("???");
			for(int i = 0; i < 9; i++) {
				squares[i].setEnabled(true);
				squares[i].setLabel("");
				squares[i].setBackground(Color.ORANGE);
			}
			emptySquaresLeft = 9;
			score.setText("Your turn!");
			newGameButton.setEnabled(false);
			return;
		}
		String winner = "";
		
		// это одна из клеток?
		for(int i = 0; i < 9; i++) {
			if(theButton == squares[i]) {
				squares[i].setLabel("X");
				winner = lookForWinner();
				if(!"".equals(winner)) {
					endTheGame();
				} 
				else {
					computerMove();
					winner = lookForWinner();
					if(!"".equals(winner)) {
						endTheGame();
					}
				}
				break;
			}
		}
		if(winner.equals("X")) {
			score.setText("You won!");
		}
		else if(winner.equals("O")) {
			score.setText("You lost!");
		}
		else if(winner.equals("T")) {
			score.setText("It's a tie!");
		}
	} // конец метода actionPerformed
	
	// Этот метод вызывается после каждого хода, чтобы узнать, есть ли победитель. 
	// Он проверяет каждый ряд, колонку и диагональ, чтобы найти три клетки с одинаковыми надписями (не пустыми). 
	// @ return "X", "O", "T" - ничья, "" - еще нет победителя
	
	@SuppressWarnings("deprecation")
	String lookForWinner() {
		
		String theWinner = "";
		emptySquaresLeft--;
		if(emptySquaresLeft == 0)
			return "T"; // это ничья
					
		// проверяем ряд 1 - элементы массива 0,1,2
		if(!squares[0].getLabel().equals("") && squares[0].getLabel().equals(squares[1].getLabel()) && squares[0].getLabel().equals(squares[2].getLabel())) {
			theWinner = squares[0].getLabel();
			highlightWinner(0,1,2);
		}
		// проверяем ряд 2 - элементы массива 3,4,5
		else if(!squares[3].getLabel().equals("") && squares[3].getLabel().equals(squares[4].getLabel()) && squares[3].getLabel().equals(squares[5].getLabel())) {
			theWinner = squares[3].getLabel();
			highlightWinner(3,4,5);
		}
		// проверяем ряд 3 - элементы массива 6,7,8
		else if(!squares[6].getLabel().equals("") && squares[6].getLabel().equals(squares[7].getLabel()) && squares[6].getLabel().equals(squares[8].getLabel())) {
			theWinner = squares[6].getLabel();
			highlightWinner(6,7,8);
		}
		// проверяем колонку 1 - элементы массива 0,3,6
		else if(!squares[0].getLabel().equals("") && squares[0].getLabel().equals(squares[3].getLabel()) && squares[0].getLabel().equals(squares[6].getLabel())) {
			theWinner = squares[0].getLabel();
			highlightWinner(0,3,6);
		}
		// проверяем колонку 2 - элементы массива 1,4,7
		else if(!squares[1].getLabel().equals("") && squares[1].getLabel().equals(squares[4].getLabel()) && squares[1].getLabel().equals(squares[7].getLabel())) {
			theWinner = squares[1].getLabel();
			highlightWinner(1,4,7);
		}
		// проверяем колонку 3 - элементы массива 2,5,8
		else if(!squares[2].getLabel().equals("") && squares[2].getLabel().equals(squares[5].getLabel()) && squares[2].getLabel().equals(squares[8].getLabel())) {
			theWinner = squares[2].getLabel();
			highlightWinner(2,5,8);
		}
		// проверяем первую диагональ - элементы массива 0,4,8
		else if(!squares[0].getLabel().equals("") && squares[0].getLabel().equals(squares[4].getLabel()) && squares[0].getLabel().equals(squares[8].getLabel())) {
			theWinner = squares[0].getLabel();
			highlightWinner(0,4,8);
		}
		// проверяем вторую диагональ - элементы массива 2,4,6
		else if(!squares[2].getLabel().equals("") && squares[2].getLabel().equals(squares[4].getLabel()) && squares[2].getLabel().equals(squares[6].getLabel())) {
			theWinner = squares[2].getLabel();
			highlightWinner(2,4,6);
		}
		return theWinner;
	}
	// Этот метод применяет набор правил, чтобы найти лучший компьютерный ход. 
	// Если хороший ход не найден, выбирается случайная клетка

	@SuppressWarnings("deprecation")
	void computerMove() {
		int selectedSquare;
		
		// сначала компьютер пытается найти пустую клетку рядом с 2 клетками с ноликами, чтобы выиграть
		selectedSquare = findEmptySquare("O");
		
		// Если не может найти 0, то хотя бы попытается не дать оппоненту сделать ряд из 3 крестиков
		if(selectedSquare == -1)
			selectedSquare = findEmptySquare("X");
		
		// если selectedSquare равен -1, то попытается занять центральную клетку
		if((selectedSquare == -1) && (squares[4].getLabel().equals("")))
			selectedSquare = 4;
		
		// если нет свободного центра - занимаем случайную
		if(selectedSquare == -1)
			selectedSquare = getRandomSquare();
		
		squares[selectedSquare].setLabel("O");
	}
	
	// Этот метод проверяет каждый ряд, колонку и диагональ чтобы узнать, есть ли в ней 2 клетки с одинаковыми надписями 
	// и пустой клеткой. Передается Х - для пользователя и О - для компа 
	// количество свободных клеток, или -1, если не найдено 2 клетки с одинаковыми надписями
	
	@SuppressWarnings("deprecation")
	int findEmptySquare(String player) {
		int weight[] = new int[9];
		
		for(int i = 0; i < 9; i++) {
			if(squares[i].getLabel().equals("O"))
				weight[i] = -1;
			else if(squares[i].getLabel().equals("X"))
				weight[i] = 1;
			else
				weight[i] = 0;
		}
		int twoWeights = player.equals("O") ? -2 : 2;
		
		// проверяем есть ли в ряду 1 две одинаковые клетки и одна пустая
		if(weight[0] + weight[1] + weight[2] == twoWeights) {
			if(weight[0] == 0)
				return 0;
			else if (weight[1] == 0)
				return 1;
			else
				return 2;
		}
		// проверим есть ли в ряду 2 две одинаковые клетки и одна пустая
		if(weight[3] + weight[4] + weight[5] == twoWeights) {
			if(weight[3] == 0)
				return 3;
			else if (weight[4] == 0)
				return 4;
			else
				return 5;
		}
		// проверим есть ли в ряду 3 две одинаковые клетки и одна пустая
		if(weight[6] + weight[7] + weight[8] == twoWeights) {
			if(weight[6] == 0)
				return 6;
			else if (weight[7] == 0)
				return 7;
			else
				return 8;
		}
		// проверим есть ли в колонке 1 две одинаковые клетки и одна пустая
		if (weight[0] + weight[3] + weight[6] == twoWeights) {
			if (weight[0] == 0)
				return 0;
			else if (weight[3] == 0)
				return 3;
			else
				return 6;
		}
		// проверим есть ли в колонке 2 две одинаковые клетки и одна пустая
		if (weight[1] + weight[4] + weight[7] == twoWeights) {
			if (weight[1] == 0)
				return 1;
			else if (weight[4] == 0)
				return 4;
			else
				return 7;
		}
		// проверим есть ли в колонке 3 две одинаковые клетки и одна пустая
		if (weight[2] + weight[5] + weight[8] == twoWeights) {
			if (weight[2] == 0)
				return 2;
			else if (weight[5] == 0)
				return 5;
			else
				return 8;
		}
		// проверим есть ли в диагонали 1 две одинаковые клетки и одна пустая
		if (weight[0] + weight[4] + weight[8] == twoWeights) {
			if (weight[0] == 0)
				return 0;
			else if (weight[4] == 0)
				return 4;
			else
				return 8;
		}
		// проверим есть ли в диагонали 2 две одинаковые клетки и одна пустая
		if (weight[2] + weight[4] + weight[6] == twoWeights) {
			if (weight[2] == 0)
				return 2;
			else if (weight[4] == 0)
				return 4;
			else
				return 6;
		}
		// не найдено 2 одинаковых соседних клеток
		return -1;
	}
	
	// Этот метод выбирает любую пустую клетку, случайно выбранный номер клетки
	
	@SuppressWarnings("deprecation")
	int getRandomSquare() {
		boolean gotEmptySquare = false;
		int selectedSquare = -1;
		
		do {
			selectedSquare = (int) (Math.random() * 9);
			if(squares[selectedSquare].getLabel().equals(""))
				gotEmptySquare = true;
		} while(!gotEmptySquare);
		return selectedSquare;
	}
	
	// Этот метод выделяет выигравшую линию. Первая, вторая и третья клетки для выделения
	void highlightWinner(int win1, int win2, int win3) {
		squares[win1].setBackground(Color.CYAN);
		squares[win2].setBackground(Color.CYAN);
		squares[win3].setBackground(Color.CYAN);
	}
	
	// Делаем недоступными клетки и доступной кнопку "New Game"
	void endTheGame() {
		newGameButton.setEnabled(true);
		for(int i = 0; i < 9; i++)
			squares[i].setEnabled(false);	
	}	
}