package ChineseCheckers.ChineseCheckers;

public class Rules extends AbstractRules
{

	private boolean isFinished;

	
	public boolean legal(Checker checker, Field newField, Board board)
	{
		if(canShortMove(checker, newField, board) || canLongMove(checker, newField, board))
			return true;
		else
			return false;
		
	}
	
	
	public int makeMove(Checker checker, Field newField, Board board)
 	{
 		if(canShortMove(checker, newField, board))
 		{
 			board.freeFieldStatus(checker.getX(), checker.getY());
 			board.changeFieldStatus(newField.getX(), newField.getY(), checker.getStartCorner());
 			board.moveChecker(checker, newField);
 			if(Math.abs(newField.getCorner()-checker.getStartCorner())==3)
 			{
 				checker.setOpposite();
 				isFinished = true;
 				for (Checker c : board.getCheckers())
 				{
 					if(c.getStartCorner()==checker.getStartCorner())
 						if(!c.isOpposite())
 						{
 							isFinished = false;
 							break;
 						}
 				}
 			}
 			
 			return -1;
 		}
 		
 		else if(canLongMove(checker, newField, board))
 		{
 			board.freeFieldStatus(checker.getX(), checker.getY());
 			board.changeFieldStatus(newField.getX(), newField.getY(), checker.getStartCorner());
 			checker.yesJumper();
 			board.moveChecker(checker, newField);
 			if(Math.abs(newField.getCorner()-checker.getStartCorner())==3)
 			{
 				checker.setOpposite();
 				isFinished = true;
 				for (Checker c : board.getCheckers())
 				{
 					if(c.getStartCorner()==checker.getStartCorner())
 						if(!c.isOpposite())
 						{
 							isFinished = false;
 							break;
 						}
 				}
 				
 			}
 			
 			return board.getNoChecker(checker.getX(), checker.getY());
 		}
 		else
 		{
 			return -2;

 		}
 	}
	
 	
 	public boolean canShortMove(Checker checker, Field temp, Board board)
	{
 		if(board.anyJumper(checker))
 			return false;
		if(checker.isOpposite() && checker.getStartCorner()!=(temp.getCorner()+3)%6)
			return false;
		if(temp.getStatus()!=0)
			return false;
		if (Math.abs(checker.getX()-temp.getX())+Math.abs(checker.getY()-temp.getY())!=2)
			return false;
		if (Math.abs(checker.getY()-temp.getY())==2)
			return false;
		return true;
	}
 	
 	public boolean canLongMove(Checker checker, Field temp, Board board)
 	{
 		if(checker.isOpposite() && checker.getStartCorner()!=(temp.getCorner()+3)%6)
			return false;
 		if(temp.getStatus()!=0)
 			return false;
		if (Math.abs(checker.getX()-temp.getX())+Math.abs(checker.getY()-temp.getY())!=4 && Math.abs(checker.getX()-temp.getX())+Math.abs(checker.getY()-temp.getY())!=2)
			return false;
		
		if (checker.getX()-temp.getX()==4 && checker.getY()-temp.getY()==0)
		{
			if (board.searchField(checker.getX()-2, checker.getY()).getStatus()!=0)
				return true;
			else
				return false;
		}
		if (temp.getX()-checker.getX()==4 && checker.getY()-temp.getY()==0)
		{
			if (board.searchField(checker.getX()+2, checker.getY()).getStatus()!=0)
				return true;
			else
				return false;
		}
		if (checker.getY()-temp.getY()==2 && checker.getX()-temp.getX()==0)
		{	
			if(board.searchField(checker.getX()-1, checker.getY()-1)!=null && board.searchField(checker.getX()+1, checker.getY()-1)!=null)
			{
				if(board.searchField(checker.getX()-1, checker.getY()-1).getStatus()!=0 || board.searchField(checker.getX()+1, checker.getY()-1).getStatus()!=0)
					return true;
				else
					return false;
			}
			else if (board.searchField(checker.getX()-1, checker.getY()-1)!=null)
			{
				if(board.searchField(checker.getX()-1, checker.getY()-1).getStatus()!=0)
					return true;
				else
					return false;
			}
			else if (board.searchField(checker.getX()+1, checker.getY()-1)!=null)
			{
				if(board.searchField(checker.getX()+1, checker.getY()-1).getStatus()!=0)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		if (temp.getY()-checker.getY()==2 && checker.getX()-temp.getX()==0)
		{
			if(board.searchField(checker.getX()-1, checker.getY()+1)!=null && board.searchField(checker.getX()+1, checker.getY()+1)!=null)
			{
				if(board.searchField(checker.getX()-1, checker.getY()+1).getStatus()!=0 || board.searchField(checker.getX()+1, checker.getY()+1).getStatus()!=0)
					return true;
				else
					return false;
			}
			else if (board.searchField(checker.getX()-1, checker.getY()+1)!=null)
			{
				if(board.searchField(checker.getX()-1, checker.getY()+1).getStatus()!=0)
					return true;
				else
					return false;
			}
			else if (board.searchField(checker.getX()+1, checker.getY()+1)!=null)
			{
				if(board.searchField(checker.getX()+1, checker.getY()+1).getStatus()!=0)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		if (Math.abs(checker.getX()-temp.getX())==2 && Math.abs(checker.getY()-temp.getY())==2)
		{
			if(board.searchField((checker.getX()+temp.getX())/2,(checker.getY()+temp.getY())/2).getStatus()!=0)
				return true;
			else
				return false;
		}
		if (Math.abs(checker.getY()-temp.getY())==1 && Math.abs(checker.getX()-temp.getX())==3)
		{
			if (temp.getX()>checker.getX())
			{
				if(board.searchField(checker.getX()+1,temp.getY())!=null && board.searchField(checker.getX()+2,checker.getY())!=null)
				{
					if(board.searchField(checker.getX()+1,temp.getY()).getStatus()!=0 || board.searchField(checker.getX()+2,checker.getY()).getStatus()!=0)
						return true;
					else
						return false;
				}
				else if(board.searchField(checker.getX()+1,temp.getY())!=null)
				{
					if(board.searchField(checker.getX()+1,temp.getY()).getStatus()!=0)
						return true;
					else
						return false;
				}
				else if(board.searchField(checker.getX()+2,checker.getY())!=null)
				{
					if(board.searchField(checker.getX()+2,checker.getY()).getStatus()!=0)
						return true;
					else
						return false;
				}
				else
					return false;
				
			}
			else
			{
				if(board.searchField(checker.getX()-1,temp.getY())!=null && board.searchField(checker.getX()-2,checker.getY())!=null)
				{
					if(board.searchField(checker.getX()-1,temp.getY()).getStatus()!=0 || board.searchField(checker.getX()-2,checker.getY()).getStatus()!=0)
						return true;
					else
						return false;
				}
				else if(board.searchField(checker.getX()-1,temp.getY())!=null)
				{
					if(board.searchField(checker.getX()-1,temp.getY()).getStatus()!=0)
						return true;
					else
						return false;
				}
				else if(board.searchField(checker.getX()-2,checker.getY())!=null)
				{
					if(board.searchField(checker.getX()-2,checker.getY()).getStatus()!=0)
						return true;
					else
						return false;
				}
				else
					return false;
				
			}
		}
		
 		return false;
 	}
 	
 	public boolean isFinished()
 	{
 		return isFinished;
 	}
}
