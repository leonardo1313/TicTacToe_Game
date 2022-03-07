package com.optimahorizonapps.tictactoe_game;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TicTacToeBoard extends View {

    private final int BOARD_COLOR;
    private final int X_COLOR;
    private final int O_COLOR;
    private final int WINNING_LINE_COLOR;

    private final Paint PAINT = new Paint();
    private int cellSize = getWidth() / 3;

    public TicTacToeBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.getTheme().
                obtainStyledAttributes(attrs, R.styleable.TicTacToeBoard,
                        0, 0);

        try {
            BOARD_COLOR = typedArray.getInteger(R.styleable.TicTacToeBoard_boardColor, 0);
            X_COLOR = typedArray.getInteger(R.styleable.TicTacToeBoard_XColor, 0);
            O_COLOR = typedArray.getInteger(R.styleable.TicTacToeBoard_OColor, 0);
            WINNING_LINE_COLOR = typedArray.getInteger(R.styleable.TicTacToeBoard_winningLineColor, 0);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);

        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimension/3;
        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        PAINT.setStyle(Paint.Style.STROKE);
        PAINT.setAntiAlias(true);

        drawGameBoard(canvas);
    }

    private void drawGameBoard(Canvas canvas) {
        PAINT.setColor(BOARD_COLOR);
        PAINT.setStrokeWidth(16);

        for(int i = 1; i < 3; i++) {
            canvas.drawLine(cellSize*i, 0, cellSize*i, canvas.getWidth(), PAINT);
        }

        for(int j = 1; j < 3; j++) {
            canvas.drawLine(0, cellSize*j, canvas.getWidth(), cellSize*j, PAINT);
        }
    }
}
