mod MyGoals* {
	protecting(STRING) -- predefined type: String
	protecting(BOOL) -- predefined type: Bool
	[Task]  -- defines a task id as string ex:(T-01), which is associated  and part of the goal.

	-- signatures
	op create : -> Task
	op task : Task String -> Task
	op goalid : Task -> String
	op checkGoalID : Task String -> Bool
	op taskid : Task Bool -> String
	op empty-list : -> ?String  -- exception condition


	-- axioms
	var S : String
	var S1 : String
	var T : Task
	var B : Bool
	eq goalid (create)  = empty-list .
	eq goalid (task(create,S)) = S .
eq goalid (task(T,S)) = goalid (T) .  -- Goals are independent of tasks, we can have multiple goals
	eq checkGoalID (create,S) = false .
	eq checkGoalID (create, S) = false .
	eq checkGoalID (task(T,S), S) = true .
	eq checkGoalID (task(T,S1), S) = checkGoalID(T, S) .
	eq taskid (create, B)  = empty-list .
	ceq taskid (task(create,S), B ) = S if B == true .
	ceq taskid (task(create,S), B ) = "Attach a goal to the tas" if B == false .
}
