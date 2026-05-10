import 'package:flutter/material.dart';

class KanbanBoardScreen extends StatelessWidget {
  final String projectName;
  const KanbanBoardScreen({super.key, required this.projectName});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(projectName),
        actions: [
          IconButton(icon: const Icon(Icons.person_add), onPressed: () {}),
        ],
      ),
      body: SingleChildScrollView(
        scrollDirection: Axis.horizontal,
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            _buildColumn('To Do', ['Task 1', 'Task 2'], Colors.grey[200]!),
            _buildColumn('In Progress', ['Task 3'], Colors.blue[100]!),
            _buildColumn('Done', ['Task 4'], Colors.green[100]!),
          ],
        ),
      ),
    );
  }

  Widget _buildColumn(String title, List<String> tasks, Color color) {
    return Container(
      width: 300,
      margin: const EdgeInsets.all(8),
      padding: const EdgeInsets.all(8),
      decoration: BoxDecoration(
        color: color,
        borderRadius: BorderRadius.circular(8),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(title, style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 18)),
          const Divider(),
          ...tasks.map((task) => Card(
            child: ListTile(title: Text(task)),
          )),
          TextButton.icon(
            onPressed: () {},
            icon: const Icon(Icons.add),
            label: const Text('Add Task'),
          ),
        ],
      ),
    );
  }
}
