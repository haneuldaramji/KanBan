import 'package:flutter/material.dart';
import 'kanban_board_screen.dart';

class ProjectListScreen extends StatelessWidget {
  const ProjectListScreen({super.key});

  @override
  Widget build(BuildContext context) {
    // 예시 데이터 (실제로는 API 호출 필요)
    final projects = ['Project A', 'Project B'];

    return Scaffold(
      appBar: AppBar(
        title: const Text('My Projects'),
        actions: [
          IconButton(icon: const Icon(Icons.add), onPressed: () {}),
        ],
      ),
      body: ListView.builder(
        itemCount: projects.length,
        itemBuilder: (context, index) {
          return ListTile(
            title: Text(projects[index]),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (_) => KanbanBoardScreen(projectName: projects[index]),
                ),
              );
            },
          );
        },
      ),
    );
  }
}
