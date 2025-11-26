<body class="bg-light text-dark">
  <div class="container py-5">

  <div class="text-center mb-5">
      <h1 class="fw-bold text-success">🛍️ Thogakade - Management System</h1>
      <p class="lead text-secondary">A modern desktop solution to manage your shop with ease and efficiency.</p>
    </div>

  <div class="mb-4">
      <h2>📖 Project Overview</h2>
      <p>
        <strong>Thogakade</strong> is a JavaFX-based shop management system built using a
        <strong>Layered Architecture</strong> for clean separation of concerns.
        It manages <strong>customers</strong>, <strong>items</strong>, <strong>suppliers</strong>, and
        <strong>employees</strong> within an intuitive and user-friendly interface.
        The system ensures efficient database access through a dedicated connection handler built using the
        <strong>Singleton Design Pattern</strong>.
      </p>
    </div>

  <div class="mb-4">
      <h2>✨ Key Features</h2>
      <ul>
        <li>👥 <strong>Customer Management</strong> — Add, edit, delete, and clear customer profiles effortlessly.</li>
        <li>📦 <strong>Item Management</strong> — Maintain inventory, update stock levels, and manage pricing.</li>
        <li>🚚 <strong>Supplier Management</strong> — Track supplier details and order histories.</li>
        <li>👨‍💼 <strong>Employee Management</strong> — Manage staff roles and employee information securely.</li>
        <li>📊 <strong>Dashboard</strong> — Interactive analytics for monthly sales and product performance.</li>
        <li>💾 <strong>Database Layer</strong> — Uses Singleton pattern for controlled DB access.</li>
      </ul>
    </div>

  <div class="mb-4">
      <h2>🚀 Getting Started</h2>
      <ol>
        <li>Clone the repository:
          <code>git clone https://github.com/Chamod100/Thoga_Kade.git</code>
        </li>
        <li>Open the project in your preferred Java IDE (IntelliJ IDEA, NetBeans, or VS Code).</li>
        <li>Ensure JavaFX runtime is configured (Java 22+ recommended).</li>
        <li>Set up your database (SQLite by default or MySQL if preferred).</li>
        <li>Run the project:<code>java -jar thogakade.jar</code></li>
      </ol>
    </div>

<div class="mb-4">
      <h2>🗂️ Project Structure</h2>
      <pre class="bg-white p-3 border rounded">
src/
  main/
    java/
      controller/      # JavaFX controllers
      model/           # Data models
      service/         # Business logic layer
      repository/      # Database access layer
      util/            # Singleton Database Connection
      app/             # Main application launcher
    resources/
      fxml/            # FXML views
      images/          # Icons and logos
      </pre>
    </div>

<div class="mb-4">
      <h2>⚙️ Tech Stack</h2>
      <ul>
        <li>☕ Java 22+</li>
        <li>🎨 JavaFX (FXML + Scene Builder)</li>
        <li>💾 SQLite (default) / MySQL (optional)</li>
        <li>📐 Layered Architecture + Singleton Pattern</li>
      </ul>
    </div>

<div class="mb-4">
      <h2>🤝 Contributing</h2>
      <p>
        Contributions are welcome! Fork the repository, create a feature branch,
        and submit a pull request with a clear description of your changes.
        💡 Adding testing details is appreciated.
      </p>
    </div>
    
<div class="mb-4">
      <h2>📜 Contact</h2>
      <p>
        For suggestions or issues, reach out at:
        <em>chamodrathnayaka008@gmail.com</em>.
      </p>
    </div>

  </div>
</body>
